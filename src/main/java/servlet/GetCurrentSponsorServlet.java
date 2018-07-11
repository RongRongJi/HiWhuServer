package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.SponsorDao;
import dao.SponsorDaoImpl;
import entity.Activity;
import entity.Sponsor;
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
 * Created by lsr on 2018/7/11.
 */
public class GetCurrentSponsorServlet extends HttpServlet {
    public GetCurrentSponsorServlet() {
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
            SponsorDao sponsorDao = new SponsorDaoImpl();
            Sponsor sponsor = sponsorDao.getSponsor(sponsorID);
            JSONObject jsonObject = JSONObject.fromObject(sponsor);
            String strObject = jsonObject.toString();
            pw.print(strObject);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
