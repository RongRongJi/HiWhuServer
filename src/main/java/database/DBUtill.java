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
    static private Connection con=null;
    public static Connection getConnect() {
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
    public static void close(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String deleteSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            statement.execute(deleteSql);
            System.out.println("删除成功");
            statement.close();
            DBUtill.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
    }

    public static void insert(String insertSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            statement.execute(insertSql);
            System.out.println("插入成功");
            statement.close();
            DBUtill.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入失败");
        }
    }
}