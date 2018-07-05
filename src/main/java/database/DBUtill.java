package database;

/**
 * Created by lsr on 2018/7/5.
 */
import java.sql.*;

public class DBUtill {
    static private String user="root";
    static private String password="111222";
    static private String driver="com.mysql.jdbc.Driver";
    static private String url="jdbc:mysql://192.168.154.7:3306/Hi_whu";
    public static Connection getConnect() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }else{
                System.out.println("数据库连接失败");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }

        return con;
    }
}