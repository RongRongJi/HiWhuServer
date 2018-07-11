package servlet;

import dao.SponsorDao;
import dao.SponsorDaoImpl;
import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Sponsor;
import entity.Student;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by lsr on 2018/7/11.
 */
public class GetCurrentStudentServlet extends HttpServlet{
    public GetCurrentStudentServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw=resp.getWriter();
        String studentID = req.getParameter("studentID");
        Statement statement=null;
        ResultSet rs=null;
        try{
            StudentDao studentDao = new StudentDaoImpl();
            Student student = studentDao.getStudent(studentID);
            JSONObject jsonObject = JSONObject.fromObject(student);
            String strObject = jsonObject.toString();
            pw.print(strObject);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
