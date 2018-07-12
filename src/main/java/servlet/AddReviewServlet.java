package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.ReviewDao;
import dao.ReviewDaoImpl;
import database.DBUtill;
import entity.Activity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/12.
 */
public class AddReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReviewServlet() {
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
        /*String title=request.getParameter("title");
        String essay=request.getParameter("essay");
        String activityID=request.getParameter("activityID");
        */
        String title="你好啊";
        String essay="晚上好！";
        String activityID="0a3c3849677141969c8fc930bcfc7122";
//        String sponsorID=request.getParameter("sponsorID");
        //或者这样写
        /*if(title!=null){
            title = new String(title.getBytes("iso-8859-1"),"UTF-8");
        }
        if(essay!=null){
            essay = new String(title.getBytes("iso-8859-1"),"UTF-8");
        }*/
        ActivityDao activityDao=new ActivityDaoImpl();
        Activity activity=activityDao.getActivityByActivityID(activityID).get(0);
        String sponsorID=activity.getSponsorID();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        if(DBUtill.compare(activity.getEndTime(),time)){
            String reviewID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
            ReviewDao reviewDao=new ReviewDaoImpl();
            int result=reviewDao.addReview(reviewID,title,essay,activityID,sponsorID);
            if(result>0){
                out.println("succeed");
            }
            else{
                out.println("failed");
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
