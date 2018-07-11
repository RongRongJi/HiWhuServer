package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/7.
 */
public class AddActivityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String path;

    public AddActivityServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String activityID= UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String title=request.getParameter("title");
        if(title!=null){
            title = new String(title.getBytes("iso-8859-1"),"UTF-8");
        }
        String startTime=request.getParameter("startTime")+":00";
        String endTime=request.getParameter("endTime")+":00";
        String registrationStartTime=request.getParameter("registrationStartTime")+":00";
        String registrationEndTime=request.getParameter("registrationEndTime")+":00";
        if(startTime!=null){
            startTime = new String(startTime.getBytes("iso-8859-1"),"UTF-8");
        }
        if(endTime!=null){
            endTime = new String(endTime.getBytes("iso-8859-1"),"UTF-8");
        }
        if(registrationStartTime!=null){
            registrationStartTime = new String(registrationStartTime.getBytes("iso-8859-1"),"UTF-8");
        }
        if(registrationEndTime!=null){
            registrationEndTime = new String(registrationEndTime.getBytes("iso-8859-1"),"UTF-8");
        }
        String location=request.getParameter("location");
        String activityProfile=request.getParameter("activityProfile");
        if(activityProfile!=null){
            activityProfile = new String(activityProfile.getBytes("iso-8859-1"),"UTF-8");
        }
        String sponsorID=request.getParameter("sponsorID");
        String type=request.getParameter("type");

        // 创建文件项目工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 设置文件上传路径
        String upload = this.getServletContext().getRealPath("/");

        // 获取系统默认的临时文件保存路径，该路径为Tomcat根目录下的temp文件夹
        String temp = System.getProperty("java.io.tmpdir");
        // 设置缓冲区大小为 5M
        factory.setSizeThreshold(1024 * 1024 * 5);
        // 设置临时文件夹为temp
        factory.setRepository(new File(temp));
        // 用工厂实例化上传组件,ServletFileUpload 用来解析文件上传请求
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

        // 解析结果放在List中
        try {
            List<FileItem> list = servletFileUpload.parseRequest(request);

            for (FileItem item : list) {
                String name = item.getFieldName();
                InputStream is = item.getInputStream();

                if (name.contains("content")) {
                    System.out.println(inputStream2String(is));
                } else if (name.contains("img")) {
                    try {
                        path = upload+"\\"+item.getName();
                        System.out.println("name = :"+item.getName());
                        ActivityDao activityDao=new ActivityDaoImpl();
                        int result = activityDao.addActivity(activityID,title,startTime,endTime,registrationStartTime,registrationEndTime,location,activityProfile,
                                sponsorID,item.getName(),type);
                        if(result>0){
                            System.out.println("succeed."+activityID);
                            out.print("succeed."+activityID);
                        }else{
                            System.out.println("failed");
                            out.print("failed");
                        }
                        inputStream2File(is, path);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            //out.write(path);  //这里我把服务端成功后，返回给客户端的是上传成功后路径
        } catch (FileUploadException e) {
            e.printStackTrace();
            System.out.println("failure");
            out.write("failure");
        }

        out.flush();
        out.close();
    }

    // 流转化成字符串
    public static String inputStream2String(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }

    // 流转化成文件
    public static void inputStream2File(InputStream is, String savePath) throws Exception {
        System.out.println("文件保存路径为:" + savePath);
        File file = new File(savePath);
        InputStream inputSteam = is;
        BufferedInputStream fis = new BufferedInputStream(inputSteam);
        FileOutputStream fos = new FileOutputStream(file);
        int f;
        while ((f = fis.read()) != -1) {
            fos.write(f);
        }
        fos.flush();
        fos.close();
        fis.close();
        inputSteam.close();

    }
}
