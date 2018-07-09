package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import database.DBUtill;
import entity.Activity;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsr on 2018/7/9.
 */
public class GetAllActivityServlet extends HttpServlet{
    public GetAllActivityServlet() {
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
        Statement statement=null;
        ResultSet rs=null;
        try{
            ActivityDao activityDao = new ActivityDaoImpl();
            List<Activity> list = activityDao.show();
            JSONArray array = JSONArray.fromObject(list);
            String strArray = array.toString();
            pw.print(strArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
