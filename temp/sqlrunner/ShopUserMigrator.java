import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Temporary tool (not business code).
 *
 * 1) create SHOP_USER when missing (DDL read from sql/create_shop_user.sql)
 * 2) copy existing MES accounts from USERPROFILE into SHOP_USER,
 *    password digest is copied as-is so users keep their current password.
 *
 * usage: java -cp .;<ojdbc8>;<orai18n> ShopUserMigrator <propertiesFile> <ddlFile> <usernames>
 * e.g.   ShopUserMigrator src/main/resources/application-sz.properties sql/create_shop_user.sql admin,buyer1
 */
public class ShopUserMigrator {

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("args: <propertiesFile> <ddlFile> <usernames>");
            return;
        }
        Properties p = new Properties();
        try (FileInputStream in = new FileInputStream(args[0])) {
            p.load(new InputStreamReader(in, StandardCharsets.UTF_8));
        }
        String ddlFile = args[1];
        String[] usernames = args[2].split(",");

        Class.forName("oracle.jdbc.OracleDriver");
        try (Connection c = DriverManager.getConnection(
                p.getProperty("spring.datasource.url"),
                p.getProperty("spring.datasource.username"),
                p.getProperty("spring.datasource.password"))) {
            c.setAutoCommit(false);

            if (!tableExists(c, "SHOP_USER")) {
                System.out.println("SHOP_USER not found, running DDL: " + ddlFile);
                int ok = 0, fail = 0;
                try (Statement st = c.createStatement()) {
                    for (String s : splitStatements(new String(
                            Files.readAllBytes(Paths.get(ddlFile)), StandardCharsets.UTF_8))) {
                        try {
                            st.execute(s);
                            ok++;
                        } catch (Exception e) {
                            fail++;
                            System.out.println("  [FAIL] " + brief(s) + " -> " + rootMsg(e));
                        }
                    }
                }
                c.commit();
                System.out.println("DDL done: ok=" + ok + " fail=" + fail);
            } else {
                System.out.println("SHOP_USER already exists, skip DDL");
            }
            ensureRoleColumn(c);

            for (String raw : usernames) {
                String username = raw.trim();
                if (username.isEmpty()) continue;
                migrateOne(c, username);
            }
            c.commit();

            System.out.println("---- SHOP_USER now holds ----");
            try (Statement st = c.createStatement();
                 ResultSet rs = st.executeQuery(
                         "select USERNAME, NICKNAME, ROLE, STATUS, SUBSTR(PASSWORD,1,8) PWD8 from SHOP_USER order by USERNAME")) {
                while (rs.next()) {
                    System.out.println("  " + rs.getString(1) + " | " + rs.getString(2)
                            + " | role=" + rs.getString(3) + " | status=" + rs.getInt(4)
                            + " | pwd=" + rs.getString(5) + "...");
                }
            }
        }
        System.out.println("DONE");
    }

    static void migrateOne(Connection c, String username) throws Exception {
        if (exists(c, username)) {
            System.out.println("[" + username + "] already in SHOP_USER, keep as is");
            return;
        }
        try (PreparedStatement ps = c.prepareStatement(
                "select MAX(PASSWORD), MAX(FULLNAME), MAX(PHONENUMBER), MAX(EMAILADDRESS), MAX(USERPOSITION) "
                        + "from USERPROFILE where USERNAME = ? group by USERNAME")) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    System.out.println("[" + username + "] NOT in USERPROFILE, skipped");
                    return;
                }
                String pwd = rs.getString(1);
                String fullname = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                String position = rs.getString(5);
                try (PreparedStatement ins = c.prepareStatement(
                        "insert into SHOP_USER (ID, USERNAME, PASSWORD, NICKNAME, PHONE, EMAIL, ROLE, STATUS, CREATE_TIME, UPDATE_TIME) "
                                + "values (RAWTOHEX(SYS_GUID()), ?, ?, ?, ?, ?, ?, 1, SYSTIMESTAMP, SYSTIMESTAMP)")) {
                    ins.setString(1, username);
                    ins.setString(2, pwd);
                    ins.setString(3, fullname == null ? username : fullname);
                    ins.setString(4, phone);
                    ins.setString(5, email);
                    ins.setString(6, position);
                    System.out.println("[" + username + "] inserted from USERPROFILE, role=" + position
                            + " pwd=" + (pwd == null ? "NULL" : pwd.substring(0, Math.min(8, pwd.length())) + "..."));
                    ins.executeUpdate();
                }
            }
        }
    }

    static boolean exists(Connection c, String username) throws Exception {
        try (PreparedStatement ps = c.prepareStatement("select count(*) from SHOP_USER where USERNAME = ?")) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }

    static boolean tableExists(Connection c, String table) throws Exception {
        try (PreparedStatement ps = c.prepareStatement("select count(*) from user_tables where table_name = ?")) {
            ps.setString(1, table);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }

    /** tolerate a SHOP_USER created before the ROLE column existed */
    static void ensureRoleColumn(Connection c) throws Exception {
        try (PreparedStatement ps = c.prepareStatement(
                "select count(*) from user_tab_columns where table_name = 'SHOP_USER' and column_name = 'ROLE'")) {
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                if (rs.getInt(1) > 0) return;
            }
        }
        try (Statement st = c.createStatement()) {
            st.execute("alter table SHOP_USER add (ROLE VARCHAR2(100))");
            c.commit();
            System.out.println("added missing column SHOP_USER.ROLE");
        }
    }

    static List<String> splitStatements(String content) {
        List<String> result = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for (String rawLine : content.split("\n")) {
            String line = rawLine.trim();
            if (line.isEmpty() || line.startsWith("--")) continue;
            for (int i = 0; i < rawLine.length(); i++) {
                char ch = rawLine.charAt(i);
                if (ch == ';') {
                    String s = cur.toString().trim();
                    if (!s.isEmpty()) result.add(s);
                    cur.setLength(0);
                } else {
                    cur.append(ch);
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
