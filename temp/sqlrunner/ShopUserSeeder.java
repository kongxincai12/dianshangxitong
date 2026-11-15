import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 临时造数工具（不属于业务代码）：在 USERPROFILE 里准备一个指定职位的测试账号。
 * 与 ShopAdminSeeder 同一套密码算法，幂等。
 * 用法: java -cp .;<ojdbc8>;<orai18n> ShopUserSeeder <propertiesFile> <username> <userposition> [plainPassword]
 */
public class ShopUserSeeder {

    static String makeMD5(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String hv = Integer.toHexString(b & 0xFF);
            if (hv.length() < 2) sb.append(0);
            sb.append(hv);
        }
        return sb.toString();
    }

    /** 与 UserServiceImpl.GetMd5Str 一致 */
    static String getMd5Str(String password) throws Exception {
        int length = Math.min(password.length(), 5);
        return makeMD5(makeMD5(password) + password.substring(0, length));
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("args: <propertiesFile> <username> <userposition> [plainPassword]");
            return;
        }
        String username = args[1];
        String position = args[2];
        String plain = args.length >= 4 ? args[3] : "123456";

        Properties p = new Properties();
        try (FileInputStream in = new FileInputStream(args[0])) {
            p.load(new InputStreamReader(in, "UTF-8"));
        }

        String hash = getMd5Str(plain);
        Class.forName("oracle.jdbc.OracleDriver");
        try (Connection c = DriverManager.getConnection(
                p.getProperty("spring.datasource.url"),
                p.getProperty("spring.datasource.username"),
                p.getProperty("spring.datasource.password"))) {
            c.setAutoCommit(false);

            int exists;
            try (PreparedStatement ps = c.prepareStatement("select count(*) from USERPROFILE where USERNAME = ?")) {
                ps.setString(1, username);
                try (ResultSet rs = ps.executeQuery()) { rs.next(); exists = rs.getInt(1); }
            }

            if (exists > 0) {
                try (PreparedStatement ps = c.prepareStatement(
                        "update USERPROFILE set PASSWORD = ?, USERPOSITION = ?, STATUS = 'ENABLED' where USERNAME = ?")) {
                    ps.setString(1, hash);
                    ps.setString(2, position);
                    ps.setString(3, username);
                    System.out.println("已存在，执行 UPDATE，影响行数 = " + ps.executeUpdate());
                }
            } else {
                String userid = nextUserId(c);
                try (PreparedStatement ps = c.prepareStatement(
                        "insert into USERPROFILE (USERID, USERNAME, PASSWORD, FULLNAME, ACTIVATIONDATE, "
                                + "EXPIRATIONDATE, FACTORYNAME, USERPOSITION, STATUS) "
                                + "values (?, ?, ?, ?, sysdate, add_months(sysdate, 120), ?, ?, ?)")) {
                    ps.setString(1, userid);
                    ps.setString(2, username);
                    ps.setString(3, hash);
                    ps.setString(4, "商城买家测试账号");
                    ps.setString(5, "SZMES工厂");
                    ps.setString(6, position);
                    ps.setString(7, "ENABLED");
                    System.out.println("执行 INSERT，USERID = " + userid + "，影响行数 = " + ps.executeUpdate());
                }
            }
            c.commit();

            try (PreparedStatement ps = c.prepareStatement(
                    "select count(*) from USERPROFILE where USERNAME = ? and PASSWORD = ?")) {
                ps.setString(1, username);
                ps.setString(2, hash);
                try (ResultSet rs = ps.executeQuery()) {
                    rs.next();
                    System.out.println("回读校验（模拟登录 SQL 命中行数）= " + rs.getInt(1));
                }
            }
            System.out.println("完成。登录请用 " + username + " / " + plain + "，职位=" + position);
        }
    }

    static String nextUserId(Connection c) throws Exception {
        long base = 90000000L;
        try (Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("select to_char(max(to_number(USERID))) from USERPROFILE")) {
            rs.next();
            String v = rs.getString(1);
            if (v != null && v.matches("[0-9]+")) base = Math.max(base, Long.parseLong(v) + 1);
        } catch (Exception ignore) {
            // 存在非数字 USERID 时 to_number 会报错，退回固定起点
        }
        try (Statement st = c.createStatement()) {
            for (long id = base; id < base + 100; id++) {
                try (ResultSet rs = st.executeQuery("select count(*) from USERPROFILE where USERID = '" + id + "'")) {
                    rs.next();
                    if (rs.getInt(1) == 0) return String.valueOf(id);
                }
            }
        }
        throw new IllegalStateException("找不到可用的 USERID");
    }
}
