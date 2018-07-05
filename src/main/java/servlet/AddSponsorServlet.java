package servlet;

import dao.SponsorDaoImpl;
import dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        String sponsorID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String sponsorName=request.getParameter("sponsorName");
        String phoneNum=request.getParameter("phoneNum");
        String password=request.getParameter("password");
        String introduction=request.getParameter("introduction");
        SponsorDaoImpl sponsorDao=new SponsorDaoImpl();
        sponsorDao.addSponsor(sponsorID,sponsorName,phoneNum,password,introduction);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}