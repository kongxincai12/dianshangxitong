import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Temporary tool (not business code): run a .sql script whose statements always
 * end with ';' at the end of a line.
 *
 * Unlike a naive "split on ;" runner this one never breaks on a semicolon that
 * sits inside a string literal, which is exactly what the exported migration
 * bundle produces (addresses and descriptions can contain ';').
 *
 * usage: java -cp .;<ojdbc8>;<orai18n> ShopSqlApply <sqlFile> <jdbcUrl> <user> <password>
 */
public class ShopSqlApply {

    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            System.out.println("args: <sqlFile> <jdbcUrl> <user> <password>");
            return;
        }
        String content = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);

        Class.forName("oracle.jdbc.OracleDriver");
        int ok = 0, fail = 0;
        try (Connection conn = DriverManager.getConnection(args[1], args[2], args[3]);
             Statement st = conn.createStatement()) {

            System.out.println("connected: " + args[1] + " as " + args[2]);
            StringBuilder cur = new StringBuilder();
            for (String raw : content.split("\n")) {
                String line = raw.trim();
                if (line.isEmpty() || line.startsWith("--") || line.startsWith("/*") || line.startsWith("*/")) {
                    continue;
                }
                cur.append(raw).append("\n");
                if (line.endsWith(";")) {
                    String sql = cur.toString().trim();
                    cur.setLength(0);
                    sql = sql.substring(0, sql.length() - 1);
                    if (sql.trim().isEmpty() || sql.trim().equalsIgnoreCase("COMMIT")) {
                        continue;
                    }
                    try {
                        st.execute(sql);
                        ok++;
                    } catch (Exception e) {
                        fail++;
                        System.out.println("[FAIL] " + brief(sql) + "  ->  " + rootMsg(e));
                    }
                }
            }
            st.execute("COMMIT");
        }
        System.out.println("finished: ok=" + ok + " fail=" + fail);
        if (fail > 0) System.exit(1);
    }

    static String brief(String s) {
        s = s.replaceAll("\\s+", " ");
        return s.length() > 90 ? s.substring(0, 90) + "..." : s;
    }

    static String rootMsg(Throwable e) {
        Throwable t = e;
        while (t.getCause() != null) t = t.getCause();
        String m = t.getMessage();
        return m == null ? t.toString() : m.replaceAll("\\s+", " ");
    }
}
