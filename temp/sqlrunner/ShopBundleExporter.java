import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Temporary tool (not business code): dump the whole shop schema + data into one
 * self-contained Oracle script so the mall can be moved to another database.
 *
 * Structure part is taken verbatim from the hand written sql/create_*.sql files
 * (their trailing seed-INSERT blocks are stripped, real rows replace them), so the
 * bundle never drifts from what a developer reads in the repository.
 *
 * usage: java -cp .;<ojdbc8>;<orai18n> ShopBundleExporter <propertiesFile> <outFile>
 */
public class ShopBundleExporter {

    /** parent tables first, so a fresh schema can be loaded top to bottom */
    static final String[] TABLES = {
        "SHOP_CATEGORY", "SHOP_PRODUCT", "SHOP_CART", "SHOP_ORDER", "SHOP_ORDER_ITEM",
        "SHOP_ADDRESS", "SHOP_USER", "PDA_PAYMENT_ORDER"
    };

    static final String[] DDL_FILES = {
        "sql/create_shop_tables.sql",
        "sql/create_shop_user.sql",
        "sql/create_shop_address_table.sql",
        "sql/create_pda_payment_order.sql"
    };

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("args: <propertiesFile> <outFile>");
            return;
        }
        Properties p = new Properties();
        try (FileInputStream in = new FileInputStream(args[0])) {
            p.load(new InputStreamReader(in, StandardCharsets.UTF_8));
        }
        String outFile = args[1];

        SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> warnings = new ArrayList<>();
        int totalRows = 0;

        Class.forName("oracle.jdbc.OracleDriver");
        try (Connection c = DriverManager.getConnection(
                p.getProperty("spring.datasource.url"),
                p.getProperty("spring.datasource.username"),
                p.getProperty("spring.datasource.password"))) {

            StringBuilder ddl = new StringBuilder();
            for (String f : DDL_FILES) {
                ddl.append("/* ---- from ").append(f).append(" ---- */\n");
                ddl.append(readDdlOnly(f)).append("\n");
            }

            Writer w = new OutputStreamWriter(Files.newOutputStream(Paths.get(outFile)), StandardCharsets.UTF_8);
            w.write("-- ============================================================\n");
            w.write("-- 电商商城一体化迁移脚本 (Oracle) : 表结构 + 全部现有数据\n");
            w.write("-- 生成时间: " + day.format(new Date()) + "\n");
            w.write("-- 导出来源: " + p.getProperty("spring.datasource.url")
                    + " / " + p.getProperty("spring.datasource.username") + "\n");
            w.write("-- 导出工具: temp/sqlrunner/ShopBundleExporter.java\n");
            w.write("--\n");
            w.write("-- 用法: sqlplus 新库用户/密码@新库 @shop_migration_oracle.sql\n");
            w.write("--   * 每条 INSERT 压成单行, 字符串里的分号不在行尾, 不会被 SQL*Plus 当成语句终止符。\n");
            w.write("--   * 字段值里的换行写成 CHR(10) 拼接, 同理避免断句。\n");
            w.write("--   * 目标库字符集与源库不同请先设 NLS_LANG, 否则中文落库即乱码。\n");
            w.write("--   * 脚本不含 DROP, 目标库这些表必须是空表, 重复执行会主键冲突。\n");
            w.write("-- ============================================================\n\n");
            w.write("-- ================= PART 1: 表结构 =================\n\n");
            w.write(ddl.toString());
            w.write("\n-- ================= PART 2: 数据 =================\n\n");

            String ddlUpper = ddl.toString().toUpperCase();
            for (String table : TABLES) {
                int rows = exportTable(c, w, table, ddlUpper, warnings);
                totalRows += rows;
                System.out.println(String.format("  %-18s %5d row(s)", table, rows));
            }
            w.write("COMMIT;\n");
            w.write("\n-- 共导出 " + totalRows + " 行。\n");
            w.close();
        }

        System.out.println("written: " + outFile + "  rows=" + totalRows);
        for (String warn : warnings) {
            System.out.println("WARN  " + warn);
        }
    }

    static int exportTable(Connection c, Writer w, String table, String ddlUpper, List<String> warnings)
            throws Exception {
        w.write("-- ---------- " + table + " ----------\n");
        try (Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("select * from " + table)) {
            ResultSetMetaData md = rs.getMetaData();
            int n = md.getColumnCount();

            StringBuilder colList = new StringBuilder();
            String[] types = new String[n];
            String block = ddlBlock(ddlUpper, table);
            for (int i = 1; i <= n; i++) {
                String col = md.getColumnName(i);
                types[i - 1] = md.getColumnTypeName(i).toUpperCase();
                if (i > 1) colList.append(", ");
                colList.append(col);
                if (block != null && !block.contains(col)) {
                    warnings.add(table + "." + col + " 在 create_*.sql 的结构段里找不到, 建表脚本需要更新");
                }
            }
            w.write("-- columns: " + colList + "\n");

            int count = 0;
            while (rs.next()) {
                StringBuilder sb = new StringBuilder("INSERT INTO ").append(table)
                        .append(" (").append(colList).append(") VALUES (");
                for (int i = 1; i <= n; i++) {
                    if (i > 1) sb.append(", ");
                    sb.append(literal(rs, i, types[i - 1]));
                }
                w.write(sb.append(");").append("\n").toString());
                count++;
            }
            if (count == 0) {
                w.write("-- (0 rows)\n");
            }
            w.write("COMMIT;\n\n");
            return count;
        }
    }

    /** one column value -> one SQL literal, never containing a raw newline */
    static String literal(ResultSet rs, int i, String type) throws Exception {
        Object v = rs.getObject(i);
        if (v == null) return "NULL";
        if (type.startsWith("TIMESTAMP")) {
            Timestamp ts = rs.getTimestamp(i);
            return "TO_TIMESTAMP('" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ts)
                    + "." + String.format("%09d", ts.getNanos()).substring(0, 6)
                    + "', 'YYYY-MM-DD HH24:MI:SS.FF')";
        }
        if (type.equals("DATE")) {
            Timestamp ts = rs.getTimestamp(i);
            String text = ts != null
                    ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ts)
                    : new SimpleDateFormat("yyyy-MM-dd").format((Date) v);
            return "TO_DATE('" + text + "', 'YYYY-MM-DD HH24:MI:SS')";
        }
        if (type.startsWith("NUMBER") || type.startsWith("FLOAT") || type.startsWith("BINARY_")) {
            return v.toString();
        }
        return quoted(rs.getString(i));
    }

    static String quoted(String s) {
        if (s == null) return "NULL";
        List<String> lines = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '\r') {
                if (i + 1 < s.length() && s.charAt(i + 1) == '\n') i++;
                lines.add(cur.toString());
                cur.setLength(0);
            } else if (ch == '\n') {
                lines.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        lines.add(cur.toString());

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            if (i > 0) out.append(" || CHR(10) ||");
            out.append(" '").append(chunk(lines.get(i).replace("'", "''"))).append("'");
        }
        return out.toString();
    }

    /** Oracle 字面量上限 4000 字节, 长文本切成多段拼接 */
    static String chunk(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 900) {
            if (i > 0) sb.append("' || '");
            sb.append(s, i, Math.min(s.length(), i + 900));
        }
        return sb.toString();
    }

    /** the CREATE TABLE text of one table from the DDL we are about to emit, for a drift check */
    static String ddlBlock(String ddlUpper, String table) {
        int start = ddlUpper.indexOf("CREATE TABLE " + table);
        if (start < 0) return null;
        int end = ddlUpper.indexOf("\n);", start);
        return end < 0 ? ddlUpper.substring(start) : ddlUpper.substring(start, end);
    }

    /** keep DDL, drop the hand-written seed / sample-account block (real rows replace it) */
    static String readDdlOnly(String file) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        int cut = -1;
        for (int i = 0; i < lines.size() && cut < 0; i++) {
            String t = lines.get(i).trim();
            if (t.startsWith("INSERT") || t.equalsIgnoreCase("COMMIT;")
                    || t.startsWith("-- 种子数据") || t.startsWith("-- 账号数据")) {
                cut = i;
            }
        }
        if (cut < 0) cut = lines.size();
        // 连同标题上方的注释带一起剪掉, 否则脚本里会残留一段指向不存在内容的说明
        while (cut > 0) {
            String prev = lines.get(cut - 1).trim();
            if (prev.startsWith("--") || prev.isEmpty()) {
                cut--;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cut; i++) {
            sb.append(lines.get(i)).append("\n");
        }
        return sb.toString();
    }
}
