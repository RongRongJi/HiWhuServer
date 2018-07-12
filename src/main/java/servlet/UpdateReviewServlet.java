package servlet;

import dao.ReviewDao;
import dao.ReviewDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lenovo on 2018/7/12.
 */
public class UpdateReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO GET DATA
        PrintWriter out = response.getWriter();
        /*String reviewID=request.getParameter("reviewID");
        String title=request.getParameter("title");
        if(title!=null){
            title = new String(title.getBytes("iso-8859-1"),"UTF-8");
        }
        String essay=request.getParameter("essay");
        if(essay!=null){
            essay = new String(essay.getBytes("iso-8859-1"),"UTF-8");
        }*/
        String reviewID="69a18dbe70b5437ebc2a8c734980601f";
        String title="下午了";
        String essay="下午好！";
        ReviewDao reviewDao =new ReviewDaoImpl();
        int result=reviewDao.updateReview(reviewID,title,essay);
        if(result>0){
            out.print("updatesucceed");
        }else{
            out.print("updatefailed");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

