package servlet;

import dao.ReviewDao;
import dao.ReviewDaoImpl;
import entity.Review;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lenovo on 2018/7/12.
 */
public class GetReviewByActivityIDServlet extends HttpServlet {
    public GetReviewByActivityIDServlet() {
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
//        String activtiyID=req.getParameter("activityID");
        String activityID="0a3c3849677141969c8fc930bcfc7122";
        try{
            ReviewDao reviewDao=new ReviewDaoImpl();
            List<Review> reviewList=reviewDao.getReviewByActivityID(activityID);
            JSONArray array = JSONArray.fromObject(reviewList);
            String strArray = array.toString();
            pw.print(strArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}