import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Temporary tool (not business code): prove that the bundle really rebuilt the mall.
 *
 * Row counts alone would not catch a charset round trip that mangled Chinese text,
 * so every table is compared with a full set difference in both directions
 * (MINUS compares every column, including the character data). The tool only ever
 * prints numbers, so a garbled console can never fake a result.
 *
 * usage: java -cp .;<ojdbc8>;<orai18n> ShopVerify <jdbcUrl> <user> <password> <srcSchema> <dstSchema>
 */
public class ShopVerify {

    static final String[] TABLES = {
        "SHOP_CATEGORY", "SHOP_PRODUCT", "SHOP_CART", "SHOP_ORDER", "SHOP_ORDER_ITEM",
        "SHOP_ADDRESS", "SHOP_USER", "PDA_PAYMENT_ORDER"
    };

    public static void main(String[] args) throws Exception {
        if (args.length < 5) {
            System.out.println("args: <jdbcUrl> <user> <password> <srcSchema> <dstSchema>");
            return;
        }
        String src = args[3], dst = args[4];
        Class.forName("oracle.jdbc.OracleDriver");
        int bad = 0;
        try (Connection c = DriverManager.getConnection(args[0], args[1], args[2])) {
            for (String t : TABLES) {
                long nSrc = count(c, "select count(*) from " + src + "." + t);
                long nDst = count(c, "select count(*) from " + dst + "." + t);
                long missing = count(c, "select count(*) from (select * from " + src + "." + t
                        + " minus select * from " + dst + "." + t + ")");
                long extra = count(c, "select count(*) from (select * from " + dst + "." + t
                        + " minus select * from " + src + "." + t + ")");
                boolean same = nSrc == nDst && missing == 0 && extra == 0;
                if (!same) bad++;
                System.out.println(String.format("  %-18s src=%-5d dst=%-5d onlyInSrc=%-4d onlyInDst=%-4d %s",
                        t, nSrc, nDst, missing, extra, same ? "IDENTICAL" : "DIFFERENT"));
            }
        }
        System.out.println(bad == 0 ? "ALL TABLES IDENTICAL" : "PROBLEMS=" + bad);
        if (bad > 0) System.exit(1);
    }

    static long count(Connection c, String sql) throws Exception {
        try (Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return rs.getLong(1);
        }
    }
}
