package servlet;

import database.DBUtill;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lenovo on 2018/7/5.
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        Statement statement=null;
        ResultSet rs=null;
        try{
            String account=request.getParameter("account");
            String password=request.getParameter("password");
            if(account!=null){
                account = new String(account.getBytes("iso-8859-1"),"UTF-8");// 从 request 中获取名为 userName 的参数的值
            }
            System.out.println(account);
            System.out.println(password);
            statement=DBUtill.getConnect().createStatement();
            String sql1="select * from student where studentID ='"+account+"' and password ='"+password+"'";
            String sql2="select * from sponsor where sponsorName= '"+account+"' and password ='"+password+"'";
            System.out.println(sql1);
            System.out.println(sql2);
            rs=statement.executeQuery(sql1);
            if(rs.next()){
                String studentID=rs.getString("studentID");
                //TODO 向安卓端传输数据
                pw.print("1."+studentID);
                System.out.print("1."+studentID);
            }else{
                rs=statement.executeQuery(sql2);
                if(rs.next()){
                    String sponsorID=rs.getString("sponsorID");
                    //TODO 向安卓端传输数据
                    pw.print("2."+sponsorID);
                    System.out.print("2."+sponsorID);
                }
                else {
                    //TODO 向安卓端传输数据
                    pw.print("failed");
                    System.out.print("登陆失败");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("登陆失败");
        }
        try {
            rs.close();
            statement.close();
            DBUtill.close();
            pw.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

