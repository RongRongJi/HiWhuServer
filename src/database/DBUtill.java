package database;

/**
 * Created by lsr on 2018/7/5.
 */
import java.sql.*;

public class DBUtill {
    static  String driver = "com.mysql.jdbc.Driver";
    static  String url="jdbc:mysql://localhost:3306/hi_whu";
    static  String user="root";
    static  String password="root";
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