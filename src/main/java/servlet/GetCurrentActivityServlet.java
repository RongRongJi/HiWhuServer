package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Activity;
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
import java.util.List;

/**
 * Created by lsr on 2018/7/12.
 */
public class GetCurrentActivityServlet extends HttpServlet {
    public GetCurrentActivityServlet() {
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
        String activityID = req.getParameter("activityID");
        Statement statement=null;
        ResultSet rs=null;
        try{
            ActivityDao activityDao = new ActivityDaoImpl();
            List<Activity> list = activityDao.getActivityByActivityID(activityID);
            if(list!=null){
                JSONObject jsonObject = JSONObject.fromObject(list.get(0));
                String strObject = jsonObject.toString();
                pw.print(strObject);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
