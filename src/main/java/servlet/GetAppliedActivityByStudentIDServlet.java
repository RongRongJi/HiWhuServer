package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.Stu_apply_activityDao;
import dao.Stu_apply_activityDaoImpl;
import entity.Activity;
import entity.Stu_apply_activity;
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
 * Created by lenovo on 2018/7/10.
 */
public class GetAppliedActivityByStudentIDServlet extends HttpServlet {
    public GetAppliedActivityByStudentIDServlet() {
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
        String studentID=req.getParameter("studentID");
        //String studentID="2016302580228";
        try{
            Stu_apply_activityDao stu_apply_activityDao=new Stu_apply_activityDaoImpl();
            List<Activity> applyList=stu_apply_activityDao.getActivityByStudentID(studentID);
            JSONArray array = JSONArray.fromObject(applyList);
            String strArray = array.toString();
            pw.print(strArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
