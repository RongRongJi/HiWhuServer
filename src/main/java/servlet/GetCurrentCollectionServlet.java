package servlet;

import dao.Stu_collect_activityDao;
import dao.Stu_collect_activityDaoImpl;
import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Stu_collect_activity;
import entity.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Created by ASUS on 2018/7/13.
 */
public class GetCurrentCollectionServlet extends HttpServlet {
    public GetCurrentCollectionServlet() {
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
            Stu_collect_activityDao stu_collect_activityDao = new Stu_collect_activityDaoImpl();
            List<Stu_collect_activity> list = stu_collect_activityDao.getActivityByStudentID(studentID);
            JSONArray jsonObject = JSONArray.fromObject(list);
            String strObject = jsonObject.toString();
            pw.print(strObject);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
