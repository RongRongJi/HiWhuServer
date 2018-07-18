package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.SponsorDao;
import dao.SponsorDaoImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.ByteArrayOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by lsr on 2018/7/13.
 */
public class UpdateSponsorServlet extends HttpServlet{
    private String path;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO GET DATA
        PrintWriter out = response.getWriter();
        String sponsorID=request.getParameter("sponsorID");
        String sponsorName=request.getParameter("sponsorName");
        String phoneNum=request.getParameter("phoneNum");
        String introduction=request.getParameter("introduction");
        if(sponsorName!=null){
            sponsorName = new String(sponsorName.getBytes("iso-8859-1"),"UTF-8");
        }
        if(introduction!=null){
            introduction = new String(introduction.getBytes("iso-8859-1"),"UTF-8");
        }
        SponsorDao sponsorDao=new SponsorDaoImpl();
        int result = sponsorDao.updateSponsor(sponsorID,sponsorName,phoneNum,introduction);
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
