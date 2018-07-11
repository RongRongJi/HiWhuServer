package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/7.
 */
public class UpdateActivityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateActivityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO GET DATA
        PrintWriter out = response.getWriter();
        String activityID=request.getParameter("activityID");
        String title=request.getParameter("title");
        if(title!=null){
            title = new String(title.getBytes("iso-8859-1"),"UTF-8");
        }
        String startTime=request.getParameter("startTime")+":00";
        String endTime=request.getParameter("endTime")+":00";
        String registrationStartTime=request.getParameter("registrationStartTime")+":00";
        String registrationEndTime=request.getParameter("registrationEndTime")+":00";
        if(startTime!=null){
            startTime = new String(startTime.getBytes("iso-8859-1"),"UTF-8");
        }
        if(endTime!=null){
            endTime = new String(endTime.getBytes("iso-8859-1"),"UTF-8");
        }
        if(registrationStartTime!=null){
            registrationStartTime = new String(registrationStartTime.getBytes("iso-8859-1"),"UTF-8");
        }
        if(registrationEndTime!=null){
            registrationEndTime = new String(registrationEndTime.getBytes("iso-8859-1"),"UTF-8");
        }
        String location=request.getParameter("location");
        String activityProfile=request.getParameter("activityProfile");
        if(activityProfile!=null){
            activityProfile = new String(activityProfile.getBytes("iso-8859-1"),"UTF-8");
        }
        String sponsorID=request.getParameter("sponsorID");
        //String type=request.getParameter("type");
        String type=request.getParameter("type");
        String image=null;
        ActivityDao activityDao=new ActivityDaoImpl();
        int result = activityDao.updateActivity(activityID,title,startTime,endTime,registrationStartTime,registrationEndTime,location,activityProfile,
                sponsorID,image,type);
        if(result>0){
            out.print("updatesucceed");
        }else{
            out.print("updatefailed");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

