package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.ReplyMessageDao;
import dao.ReplyMessageDaoImpl;
import entity.Activity;
import entity.ReplyMessage;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lenovo on 2018/7/11.
 */
public class StudentGetReplyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGetReplyServlet() {
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
//        String studentID=request.getParameter("studentID");
        String studentID="2016302580228";
        ReplyMessageDao replyMessageDao=new ReplyMessageDaoImpl();
        List<ReplyMessage> replyMessageList=replyMessageDao.getMessageByStudentID(studentID);
        JSONArray array = JSONArray.fromObject(replyMessageList);
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