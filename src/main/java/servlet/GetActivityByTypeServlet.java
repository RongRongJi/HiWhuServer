package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import entity.Activity;
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
public class GetActivityByTypeServlet extends HttpServlet {
    public GetActivityByTypeServlet() {
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
//        String type=req.getParameter("type");
        String type="1";
        ActivityDao activityDao = new ActivityDaoImpl();
        List<Activity> list = activityDao.getActivityByType(type);
        JSONArray array = JSONArray.fromObject(list);
        String strArray = array.toString();
        pw.print(strArray);
    }
}

