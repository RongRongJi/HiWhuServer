package servlet;

import dao.MessageDao;
import dao.MessageDaoImpl;
import dao.Stu_apply_activityDao;
import dao.Stu_apply_activityDaoImpl;
import entity.Message;
import net.sf.json.JSONArray;

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
 * Created by lenovo on 2018/7/10.
 */
public class GetMessageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMessageServlet() {
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
        MessageDao messageDao=new MessageDaoImpl();
        List<Message> messageList=messageDao.getMessageByStudentID(studentID);
        JSONArray array = JSONArray.fromObject(messageList);
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