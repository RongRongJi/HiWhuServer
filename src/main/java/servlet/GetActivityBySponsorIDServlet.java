package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.MessageDao;
import dao.MessageDaoImpl;
import entity.Activity;
import entity.Message;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lenovo on 2018/7/10.
 */
public class GetActivityBySponsorIDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetActivityBySponsorIDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String sponsorID=request.getParameter("sponsorID");
        //String sponsorID="7ad528dd6c8f46bf8407de39487de1a3";
        ActivityDao activityDao=new ActivityDaoImpl();
        List<Activity> activityList=activityDao.getActivityBySponsorID(sponsorID);
        JSONArray array = JSONArray.fromObject(activityList);
        String strArray = array.toString();
        out.print(strArray);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}