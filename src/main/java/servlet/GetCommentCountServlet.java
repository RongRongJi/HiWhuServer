package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.CommentDao;
import dao.CommentDaoImpl;
import entity.Activity;
import entity.CommentWithActivity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Created by ASUS on 2018/7/17.
 */
public class GetCommentCountServlet extends HttpServlet{
    public GetCommentCountServlet() {
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
        String sponsorID = req.getParameter("sponsorID");
        Statement statement=null;
        ResultSet rs=null;
        try{
            CommentDao commentDao = new CommentDaoImpl();
            List<CommentWithActivity> list = commentDao.getCommentCount(sponsorID);
            if(list!=null){
                JSONArray jsonObject = JSONArray.fromObject(list);
                String strObject = jsonObject.toString();
                pw.print(strObject);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
