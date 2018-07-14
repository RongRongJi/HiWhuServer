package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.Stu_collect_activityDao;
import dao.Stu_collect_activityDaoImpl;
import entity.Activity;
import entity.Stu_collect_activity;
import net.sf.json.JSONArray;

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
 * Created by lsr on 2018/7/14.
 */
public class GetCollectionListByStudentID extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String studentID = req.getParameter("studentID");
        PrintWriter pw=resp.getWriter();
        Statement statement=null;
        ResultSet rs=null;
        try{
            Stu_collect_activityDao stu_collect_activityDao = new Stu_collect_activityDaoImpl();
            List<Activity> list = stu_collect_activityDao.getActivityListByStudentID(studentID);
            JSONArray array = JSONArray.fromObject(list);
            String strArray = array.toString();
            pw.print(strArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
