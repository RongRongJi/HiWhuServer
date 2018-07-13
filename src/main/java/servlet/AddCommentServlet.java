package servlet;

import dao.*;
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
 * Created by lenovo on 2018/7/10.
 */
public class AddCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
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
//        String fromUserID=request.getParameter("fromUserID");
//        String content=request.getParameter("content");
//        String activityID=request.getParameter("activityID");
//        String commentID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String fromUserID="2016302580228";
        String content="你好";
        String activityID="8342fc4d55f34d19956a8c230b628e4d";
        String commentID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
        CommentDao commentDao=new CommentDaoImpl();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        int result=commentDao.addComment(fromUserID,content,activityID,commentID,time);
        if(result>0){
            out.print("succeed."+activityID);
            ActivityDao activityDao=new ActivityDaoImpl();
            Activity activity=activityDao.getActivityByActivityID(activityID).get(0);
            LeaveMessageDao leaveMessageDao=new LeaveMessageDaoImpl();
            String lMessageID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
            int result1=leaveMessageDao.addLMessage(lMessageID,time,"您发布的"+activity.getTitle()+"活动收到一条留言："+content,fromUserID,
                    activity.getSponsorID(),activityID,commentID);
            if(result1<=0){
                commentDao.deleteCommentByCommentID(commentID);
            }
        }else{
            out.print("failed");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
