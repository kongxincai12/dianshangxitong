import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Temporary tool (not business code): run one SELECT and dump the rows.
 *
 * Output goes to a UTF-8 file instead of stdout on purpose: the Windows console code
 * page can turn Chinese data into question marks, which would make a real data problem
 * indistinguishable from a display problem.
 *
 * usage: java -cp .;<ojdbc8>;<orai18n> ShopQuery <jdbcUrl> <user> <password> <sqlFile> <outFile>
 */
public class ShopQuery {

    public static void main(String[] args) throws Exception {
        if (args.length < 5) {
            System.out.println("args: <jdbcUrl> <user> <password> <sqlFile> <outFile>");
            return;
        }
        String sql = new String(Files.readAllBytes(Paths.get(args[3])), StandardCharsets.UTF_8).trim();
        StringBuilder out = new StringBuilder();
        Class.forName("oracle.jdbc.OracleDriver");
        try (Connection c = DriverManager.getConnection(args[0], args[1], args[2]);
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();
            for (int i = 1; i <= cols; i++) {
                out.append(md.getColumnName(i)).append(i > cols ? "" : "\t");
            }
            out.append('\n');
            int rows = 0;
            while (rs.next()) {
                rows++;
                for (int i = 1; i <= cols; i++) {
                    if (i > 1) out.append('\t');
                    out.append(rs.getString(i));
                }
                out.append('\n');
            }
            out.append("rows=").append(rows).append('\n');
        }
        Files.write(Paths.get(args[4]), out.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println("written: " + args[4]);
    }
}
