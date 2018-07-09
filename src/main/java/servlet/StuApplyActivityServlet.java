package servlet;

import dao.ActivityDaoImpl;
import dao.Stu_apply_activityDaoImpl;
import database.DBUtill;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2018/7/9.
 */
public class StuApplyActivityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuApplyActivityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //TODO GET DATA
//        String studentID=request.getParameter("studentID");
//        String activityID=request.getParameter("activityID");
        String studentID="2016302580228";
        String activityID="8342fc4d55f34d19956a8c230b628e4d";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        String state="1";//1代表已报名未审核，2代表报名已审核已通过，3代表报名已审核被拒绝
        // TODO 得到报名信息数据
        String registrationEndTime=new ActivityDaoImpl().selectActivity(activityID).get(0).getRegistrationEndTime();
        if(DBUtill.compare(time,registrationEndTime)){
            Stu_apply_activityDaoImpl stu_apply_activityDao=new Stu_apply_activityDaoImpl();
            int result = stu_apply_activityDao.addApply(studentID,activityID,time,state);
            if(result>0){
                out.print("succeed");
            }else{
                out.print("failed");
            }
        }
        else{
            out.print("报名已经结束");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
