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
 * 一次性数据准备工具（临时，不属于业务代码）：
 * 在 USERPROFILE 里准备一个商城测试账号 admin，密码按后端 GetMd5Str 的算法存摘要。
 * 幂等：已存在则只把 PASSWORD 重置为目标摘要，其它字段不动；不会碰 lijie 等既有账号。
 * 用法: java -cp .;<ojdbc8.jar>;<orai18n.jar> ShopAdminSeeder <propertiesFile> [明文密码]
 */
public class ShopAdminSeeder {

    /** 与 UserServiceImpl.makeMD5 一致：小写十六进制、不足两位补 0 */
    static String makeMD5(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes("UTF-8"));
        StringBuilder pwd = new StringBuilder();
        for (byte b : digest) {
            String hv = Integer.toHexString(b & 0xFF);
            if (hv.length() < 2) pwd.append(0);
            pwd.append(hv);
        }
        return pwd.toString();
    }

    /** 与 UserServiceImpl.GetMd5Str 一致：md5(md5(pwd) + pwd 前 min(len,5) 位) */
    static String getMd5Str(String password) throws Exception {
        int length = Math.min(password.length(), 5);
        return makeMD5(makeMD5(password) + password.substring(0, length));
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("args: <propertiesFile> [plainPassword]");
            return;
        }
        String plain = args.length >= 2 ? args[1] : "123456";
        Properties p = new Properties();
        try (FileInputStream in = new FileInputStream(args[0])) {
            p.load(new InputStreamReader(in, "UTF-8"));
        }

        String hash = getMd5Str(plain);
        System.out.println("目标账号 = admin, 摘要长度 = " + hash.length() + " (PASSWORD 列宽 32)");

        Class.forName("oracle.jdbc.OracleDriver");
        try (Connection c = DriverManager.getConnection(
                p.getProperty("spring.datasource.url"),
                p.getProperty("spring.datasource.username"),
                p.getProperty("spring.datasource.password"))) {
            c.setAutoCommit(false);

            int exists;
            try (Statement st = c.createStatement();
                 ResultSet rs = st.executeQuery("select count(*) from USERPROFILE where USERNAME = 'admin'")) {
                rs.next();
                exists = rs.getInt(1);
            }

            if (exists > 0) {
                try (PreparedStatement ps = c.prepareStatement(
                        "update USERPROFILE set PASSWORD = ? where USERNAME = 'admin'")) {
                    ps.setString(1, hash);
                    System.out.println("admin 已存在，执行 UPDATE，影响行数 = " + ps.executeUpdate());
                }
            } else {
                // 参照既有 lijie 行的组织字段，避免其它模块读到 null
                String userid = nextUserId(c);
                try (PreparedStatement ps = c.prepareStatement(
                        "insert into USERPROFILE (USERID, USERNAME, PASSWORD, FULLNAME, ACTIVATIONDATE, "
                                + "EXPIRATIONDATE, FACTORYNAME, USERPOSITION, STATUS) "
                                + "values (?, ?, ?, ?, sysdate, add_months(sysdate, 120), ?, ?, ?)")) {
                    ps.setString(1, userid);
                    ps.setString(2, "admin");
                    ps.setString(3, hash);
                    ps.setString(4, "商城测试账号");
                    ps.setString(5, "SZMES工厂");
                    ps.setString(6, "工程师");
                    ps.setString(7, "ENABLED");
                    System.out.println("执行 INSERT，USERID = " + userid + "，影响行数 = " + ps.executeUpdate());
                }
            }

            c.commit();

            // 回读校验：只验证等值匹配，不打印摘要内容
            try (Statement st = c.createStatement();
                 ResultSet rs = st.executeQuery(
                         "select count(*) from USERPROFILE where USERNAME = 'admin' and PASSWORD = '" + hash + "'")) {
                rs.next();
                System.out.println("回读校验（模拟登录 SQL 命中行数）= " + rs.getInt(1));
            }
            try (Statement st = c.createStatement();
                 ResultSet rs = st.executeQuery(
                         "select USERID, FULLNAME, USERPOSITION, STATUS, length(PASSWORD) from USERPROFILE where USERNAME = 'admin'")) {
                while (rs.next()) {
                    System.out.println("最终行：USERID=" + rs.getString(1) + " FULLNAME=" + rs.getString(2)
                            + " POS=" + rs.getString(3) + " STATUS=" + rs.getString(4)
                            + " pwdLen=" + rs.getInt(5));
                }
            }
            System.out.println("完成。登录请用 admin / " + plain);
        }
    }

    /** 取一个没被占用的纯数字 USERID：以现有最大数字 ID + 1 为起点，撞车就继续往上加 */
    static String nextUserId(Connection c) throws Exception {
        long base = 90000000L;
        try (Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(
                     "select to_char(max(to_number(USERID))) from USERPROFILE")) {
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
