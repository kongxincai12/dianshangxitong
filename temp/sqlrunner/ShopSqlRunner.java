import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 一次性 SQL 执行器 (临时工具, 不属于业务代码)。
 * 用法: java ShopSqlRunner <sqlFile> <jdbcUrl> <user> <password> [dropFirst]
 * 例:  java ShopSqlRunner create_shop_tables.sql "jdbc:oracle:thin:@//localhost:1521/orcl" JCD_SZ **** DROP
 */
public class ShopSqlRunner {

    static final String[] DROP_TABLES = {
        "SHOP_ORDER_ITEM", "SHOP_ORDER", "SHOP_CART", "SHOP_PRODUCT", "SHOP_CATEGORY"
    };

    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            System.out.println("args: <sqlFile> <jdbcUrl> <user> <password> [DROP]");
            return;
        }
        String sqlFile = args[0];
        String url = args[1];
        String user = args[2];
        String pass = args[3];
        boolean dropFirst = args.length >= 5 && "DROP".equalsIgnoreCase(args[4]);

        String content = new String(Files.readAllBytes(Paths.get(sqlFile)), StandardCharsets.UTF_8);
        List<String> stmts = splitStatements(content);

        Class.forName("oracle.jdbc.OracleDriver");
        int ok = 0, fail = 0;
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement st = conn.createStatement()) {

            System.out.println("Connected: " + url + " as " + user);

            if (dropFirst) {
                System.out.println("== DROP 阶段 ==");
                for (String t : DROP_TABLES) {
                    try {
                        st.execute("DROP TABLE " + t + " CASCADE CONSTRAINTS");
                        System.out.println("[dropped] " + t);
                    } catch (Exception e) {
                        System.out.println("[skip]    " + t + " (" + rootMsg(e) + ")");
                    }
                }
            }

            System.out.println("== 执行建表脚本 (" + stmts.size() + " 条) ==");
            for (String s : stmts) {
                if (s.trim().isEmpty() || s.trim().equalsIgnoreCase("COMMIT")) continue;
                try {
                    st.execute(s);
                    ok++;
                    System.out.println("[OK]   " + brief(s));
                } catch (Exception e) {
                    fail++;
                    System.out.println("[FAIL] " + brief(s) + "  ->  " + rootMsg(e));
                }
            }
            st.execute("COMMIT");
        }
        System.out.println("== 完成: 成功 " + ok + " 条, 失败 " + fail + " 条 ==");
    }

    static List<String> splitStatements(String content) {
        List<String> result = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for (String rawLine : content.split("\n")) {
            String line = rawLine.trim();
            if (line.isEmpty() || line.startsWith("--")) continue; // 跳过注释与空行
            int idx;
            // 逐字符拼接, 遇到分号即一条语句结束 (本脚本字符串常量内不含分号)
            for (int i = 0; i < rawLine.length(); i++) {
                char c = rawLine.charAt(i);
                if (c == ';') {
                    String s = cur.toString().trim();
                    if (!s.isEmpty()) result.add(s);
                    cur.setLength(0);
                } else {
                    cur.append(c);
                }
            }
            cur.append(" ");
        }
        String tail = cur.toString().trim();
        if (!tail.isEmpty()) result.add(tail);
        return result;
    }

    static String brief(String s) {
        s = s.replaceAll("\\s+", " ");
        return s.length() > 60 ? s.substring(0, 60) + "..." : s;
    }

    static String rootMsg(Throwable e) {
        Throwable t = e;
        while (t.getCause() != null) t = t.getCause();
        String m = t.getMessage();
        return m == null ? t.toString() : m.replaceAll("\\s+", " ");
    }
}
