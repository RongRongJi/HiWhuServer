package servlet;

import dao.Stu_apply_activityDao;
import dao.Stu_apply_activityDaoImpl;
import entity.StuApplyResult;
import entity.Stu_apply_activity;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lenovo on 2018/7/13.
 */
public class AllAppliedActivityResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAppliedActivityResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO GET DATA
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
//        String studentID = request.getParameter("studentID"); // 从 request 中获取名为 account 的参数的值
        String studentID="2016302580140";
        Stu_apply_activityDao stu_apply_activityDao=new Stu_apply_activityDaoImpl();
        List<Stu_apply_activity> stuApplyResultList=stu_apply_activityDao.getAllAppliedActivityResult(studentID);
        JSONArray array = JSONArray.fromObject(stuApplyResultList);
        String strArray = array.toString();
        out.print(strArray);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
