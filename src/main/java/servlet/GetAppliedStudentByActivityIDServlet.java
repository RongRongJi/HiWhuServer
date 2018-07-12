package servlet;

import dao.Stu_apply_activityDao;
import dao.Stu_apply_activityDaoImpl;
import entity.Activity;
import entity.Student;
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
public class GetAppliedStudentByActivityIDServlet extends HttpServlet {
    public GetAppliedStudentByActivityIDServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw=resp.getWriter();
        String activityID=req.getParameter("activityID");
        //String activityID="8342fc4d55f34d19956a8c230b628e4d";
        try{
            Stu_apply_activityDao stu_apply_activityDao=new Stu_apply_activityDaoImpl();
            List<Student> studentList=stu_apply_activityDao.getStudentByActivityID(activityID);
            JSONArray array = JSONArray.fromObject(studentList);
            String strArray = array.toString();
            pw.print(strArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
