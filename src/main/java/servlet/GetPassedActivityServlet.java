package servlet;

import dao.MessageDao;
import dao.MessageDaoImpl;
import dao.Stu_apply_activityDao;
import dao.Stu_apply_activityDaoImpl;
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
public class GetPassedActivityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPassedActivityServlet() {
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
        PrintWriter pw=response.getWriter();
//        String studentID=req.getParameter("studentID");
        String studentID="2016302580228";
        try{
            Stu_apply_activityDao stu_apply_activityDao=new Stu_apply_activityDaoImpl();
            List<Activity> applyList=stu_apply_activityDao.getActivityByStudentIDAndState2(studentID);
            JSONArray array = JSONArray.fromObject(applyList);
            String strArray = array.toString();
            pw.print(strArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}