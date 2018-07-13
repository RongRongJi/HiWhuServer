package servlet;

import dao.CommentDao;
import dao.CommentDaoImpl;
import entity.CommentAndReply;
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
public class GetCommentByActivityIDServlet extends HttpServlet {
    public GetCommentByActivityIDServlet() {
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
        CommentDao commentDao=new CommentDaoImpl();
        List<CommentAndReply> commentAndReplyList=commentDao.getCommentAndReplyByActivityID(activityID);
        JSONArray array = JSONArray.fromObject(commentAndReplyList);
        String strArray = array.toString();
        pw.print(strArray);
    }
}
