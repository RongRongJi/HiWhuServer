package servlet;

import dao.SponsorDaoImpl;
import dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/5.
 */
public class AddSponsorServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSponsorServlet() {
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
        String sponsorID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String sponsorName=request.getParameter("sponsorName");
        String phoneNum=request.getParameter("phoneNum");
        String password=request.getParameter("password");
        String introduction=request.getParameter("introduction");
        if(sponsorName!=null){
            sponsorName = new String(sponsorName.getBytes("iso-8859-1"),"UTF-8");
        }
        if(introduction!=null){
            introduction = new String(introduction.getBytes("iso-8859-1"),"UTF-8");
        }
        String headimage = "logo.png";
        SponsorDaoImpl sponsorDao=new SponsorDaoImpl();
        int result = sponsorDao.addSponsor(sponsorID,sponsorName,phoneNum,password,introduction,headimage);
        if(result>0){
            out.println("succeed");
        }
        else{
            out.println("failed");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}