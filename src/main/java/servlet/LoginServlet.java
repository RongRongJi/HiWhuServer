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
        PrintWriter pw=response.getWriter();
        Statement statement=null;
        ResultSet rs=null;
        try{
            /*String account=request.getParameter("account");
            String password=request.getParameter("password");*/
            String account = "2016302580251";
            String password="hiwhu";
            statement=DBUtill.getConnect().createStatement();
            String sql1="select * from Student where studentID ='"+account+"' and password ='"+password+"'";
            String sql2="select * from Sponsor where sponsorName= '"+account+"' and password ='"+password+"'";
            rs=statement.executeQuery(sql1);
            if(rs.next()){
                String studentID=rs.getString("studentID");
                //TODO 向安卓端传输数据
                pw.print("登陆成功");
                System.out.print("登陆成功");
            }else{
                rs=statement.executeQuery(sql2);
                if(rs.next()){
                    String sponsorID=rs.getString("sponsorID");
                    //TODO 向安卓端传输数据
                    pw.print("登陆成功");
                    System.out.print("登陆成功");
                }
                else {
                    //TODO 向安卓端传输数据
                    pw.print("登陆失败");
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

