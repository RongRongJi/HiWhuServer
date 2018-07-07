package database;

/**
 * Created by lsr on 2018/7/5.
 */
import java.sql.*;

public class DBUtill {
    static private String user="root";
    static private String password="root";
    static private String driver="com.mysql.jdbc.Driver";
    static private String url="jdbc:mysql://139.219.140.158:3306/hi_whu?characterEncoding=utf8";
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

    public static int delete(String deleteSql){
        int result = 0;
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            result = statement.executeUpdate(deleteSql);
            System.out.println("删除成功");
            statement.close();
            DBUtill.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
        return result;
    }

    public static int insert(String insertSql){
        int result = 0;
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            result = statement.executeUpdate(insertSql);
            System.out.println("插入成功");
            statement.close();
            DBUtill.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入失败");
        }
        return result;
    }

    public static int update(String updateSql){
        int result=0;
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            result=statement.executeUpdate(updateSql);
            System.out.println(result);
            System.out.println("更改成功");
            statement.close();
            DBUtill.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("更改失败");
        }
        return result;
    }
}