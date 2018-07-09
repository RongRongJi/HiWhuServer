package servlet;

import dao.Stu_apply_activityDaoImpl;
import dao.Stu_collect_activityDaoImpl;
import entity.Stu_collect_activity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
        Stu_apply_activityDaoImpl stu_apply_activityDao=new Stu_apply_activityDaoImpl();
        int result=stu_apply_activityDao.passApply(studentID,activityID);
        if(result>0){
            out.print("succeed");
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
