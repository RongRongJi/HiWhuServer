package servlet;

/**
 * Created by lsr on 2018/7/5.
 */
import dao.*;
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
 * Servlet implementation class MyServlet
 */
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String path;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO GET DATA
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String studentID = request.getParameter("studentID"); // 从 request 中获取名为 account 的参数的值
        String userName=request.getParameter("userName");
        if(userName!=null){
            userName = new String(userName.getBytes("iso-8859-1"),"UTF-8");// 从 request 中获取名为 userName 的参数的值
        }
        String password = request.getParameter("password"); // 从 request 中获取名为 password 的参数的值
        System.out.println(request.getRequestURL());
        System.out.println(studentID);
        System.out.println(userName);
        System.out.print(password);

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
                        StudentDao studentDao=new StudentDaoImpl();
                        int result = studentDao.addStudent(studentID,userName,password,item.getName());
                        if(result>0){
                            System.out.println("succeed."+studentID);
                            out.print("succeed."+studentID);
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

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
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
