package servlet;

import dao.*;
import entity.Message;
import entity.Stu_collect_activity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/9.
 */
public class PassApplyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        String studentID=request.getParameter("studentID");
//        String activityID=request.getParameter("activityID");
        String studentID="2016302580228";
        String activityID="8342fc4d55f34d19956a8c230b628e4d";
        Stu_apply_activityDao stu_apply_activityDao=new Stu_apply_activityDaoImpl();
        int result=stu_apply_activityDao.passApply(studentID,activityID);
        if(result>0){
            out.println("pass");
            String messageID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
            MessageDao messageDao=new MessageDaoImpl();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String time=df.format(new Date());// new Date()为获取当前系统时间
            int result1=messageDao.addPassMessage(messageID,studentID,activityID,time);
            if(result1>0){
                out.println("MessageInsert");
            }
            else {
                out.println("MessageInsertFailed");
            }
        }else{
            out.println("failedPass");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
