package servlet;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import dao.Stu_apply_activityDaoImpl;
import entity.Activity;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static dao.ChangeUTF8.changeUTF8;

/**
 * Created by lenovo on 2018/7/9.
 */
public class SearchActivity extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchActivity() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String keyStr=request.getParameter("keyStr");
        if(keyStr!=null){
            keyStr=changeUTF8(keyStr);
            //keyStr = new String(keyStr.getBytes("iso-8859-1"),"UTF-8");// 从 request 中获取名为 userName 的参数的值
        }
        //String keyStr="国软";
        try{
            ActivityDao activityDao=new ActivityDaoImpl();
            List<Activity> activityList=activityDao.selectActivity(keyStr);
            JSONArray array = JSONArray.fromObject(activityList);
            String strArray = array.toString();
            out.print(strArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

