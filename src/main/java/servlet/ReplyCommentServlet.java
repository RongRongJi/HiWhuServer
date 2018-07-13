package servlet;

import dao.*;
import entity.Activity;
import entity.Comment;
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
public class ReplyCommentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyCommentServlet() {
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
        String fromUserID=request.getParameter("fromUserID");
        String refCommentID=request.getParameter("refCommentID");
        String content=request.getParameter("content");
        if(content!=null){
            content = new String(content.getBytes("iso-8859-1"),"UTF-8");// 从 request 中获取名为 userName 的参数的值
        }
        String activityID=request.getParameter("activityID");
        String commentID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
        //String fromUserID="81fb8660dfab43f6b23fc0a444f1dd7b";
        //String refCommentID="2d5d26decf734bdf96642835fa177b1c";
        //String content="ok";
        //String activityID="8342fc4d55f34d19956a8c230b628e4d";
        //String commentID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
        CommentDao commentDao=new CommentDaoImpl();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        int result=commentDao.replyComment(fromUserID,refCommentID,content,activityID,commentID,time);
        if(result>0){
            out.print("succeed."+activityID);
            ActivityDao activityDao=new ActivityDaoImpl();
            Activity activity=activityDao.getActivityByActivityID(activityID).get(0);
            Comment comment=commentDao.getCommentByCommentID(refCommentID).get(0);
            LeaveMessageDao leaveMessageDao=new LeaveMessageDaoImpl();
            String lMessageID=leaveMessageDao.getMessageByCommentID(refCommentID).get(0).getlMessageID();
            ReplyMessageDao replyMessageDao=new ReplyMessageDaoImpl();
            String rMessageID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
            int result1=replyMessageDao.addRMessage(rMessageID,time,"您在"+activity.getTitle()+"活动留下的留言收到活动主办方的一条回复："+content,fromUserID,
                    comment.getFromUserID(),activityID,commentID,lMessageID);
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