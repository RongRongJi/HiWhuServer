package servlet;

import dao.ActivityDaoImpl;
import dao.Stu_apply_activityDaoImpl;
import dao.Stu_collect_activityDao;
import dao.Stu_collect_activityDaoImpl;
import database.DBUtill;
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

/**
 * Created by lenovo on 2018/7/9.
 */
public class StuCollectActivityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuCollectActivityServlet() {
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
        System.out.println(studentID);
        System.out.println(activityID);
        Stu_collect_activityDao stu_collect_activityDao=new Stu_collect_activityDaoImpl();
        List<Stu_collect_activity> collectList=stu_collect_activityDao.getActivityByStudentIDAndActivityID(studentID,activityID);
        int result=0;
        if(collectList.size()!=0){
            result=stu_collect_activityDao.deleteCollect(studentID,activityID);
        }
        else {
            result = stu_collect_activityDao.addCollect(studentID,activityID);
        }
        if(result>0){
            out.println("succeed");
        }
        else{
            out.println("failed");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
