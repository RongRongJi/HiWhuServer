package servlet;

/**
 * Created by lsr on 2018/7/5.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDaoImpl;
import database.DBUtill;

/**
 * Servlet implementation class MyServlet
 */
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO GET DATA
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String studentID = request.getParameter("studentID"); // 从 request 中获取名为 account 的参数的值
        String userName=request.getParameter("userName");
        if(userName!=null){
            userName = new String(userName.getBytes("iso-8859-1"),"UTF-8");// 从 request 中获取名为 userName 的参数的值
        }
        String password = request.getParameter("password"); // 从 request 中获取名为 password 的参数的值
        System.out.println(request.getRequestURL());
        System.out.println(studentID);
        System.out.println(userName);
        System.out.print(password);
        String headimage = "logo.png";
        StudentDaoImpl stu=new StudentDaoImpl();
        int result = stu.addStudent(studentID,userName,password,headimage);
        if(result>0){
            out.println("succeed");
        }
        else{
            out.println("failed");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}