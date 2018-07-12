package dao;

import database.DBUtill;
import entity.Activity;
import entity.Sponsor;
import net.sf.json.JSONArray;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/7/7.
 */
public class ActivityDaoImpl implements ActivityDao {
    //展示所有活动
    public List<Activity> show(){
        List<Activity> activityList=new ArrayList<>();
        String selectSql="select * from activity";
        select(activityList,selectSql);
        return activityList;
    }
    //通过activityID删除活动
    public int deleteActivity(String activityID){
        String deleteSql="delete from activity where activityID='"+activityID+"';";
        System.out.println(deleteSql);
        return DBUtill.delete(deleteSql);
    }
    //插入活动
    public int addActivity(String activityID,String title,String startTime,String endTime,String registrationStartTime,String registrationEndTime,
                           String location,String activityProfile,String sponsorID,String image,String type){
        String insertSql="insert into activity values ('"+activityID+"','"+title+"',str_to_date('"+startTime+"','%Y-%m-%d %H:%i:%s')," +
                "str_to_date('"+endTime+"','%Y-%m-%d %H:%i:%s'),str_to_date('"+registrationStartTime +"','%Y-%m-%d %H:%i:%s')," +
                "str_to_date('"+registrationEndTime+"','%Y-%m-%d %H:%i:%s'),'"+location+"','"+activityProfile+"','"
                +sponsorID+"','"+image+"','"+type+"');";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }
    //更新活动信息
    public int updateActivity(String activityID,String title,String startTime,String endTime,String registrationStartTime,String registrationEndTime,
                              String location,String activityProfile,String sponsorID,String image,String type){
        String updateSql="update activity set title='"+title+"',startTime=str_to_date('"+startTime+"','%Y-%m-%d %H:%i:%s')," +
                "endTime=str_to_date('"+endTime+"','%Y-%m-%d %H:%i:%s')," +
                "registrationStartTime=str_to_date('"+registrationStartTime+"','%Y-%m-%d %H:%i:%s')," +
                "registrationEndTime=str_to_date('"+registrationEndTime+"','%Y-%m-%d %H:%i:%s'),location='"
                +location+"',activityProfile='"+activityProfile+"',sponsorID='"+sponsorID+"',image='"+image+"',type='"+type+
                "' where activityID='"+activityID+"';";
        System.out.println(updateSql);
        return DBUtill.update(updateSql);
    }

    //添加活动图片
    public int addImage(String activityID, String image){
        String updateSql="update activity set image='"+image+"' where activityID='"+activityID+"';";
        System.out.println(updateSql);
        return DBUtill.update(updateSql);
    }


    //通过关键字查找活动
    public List<Activity> selectActivity(String string){
        List<Activity> activityList=new ArrayList<>();
        String selectSql="select * from activity where activityID LIKE '%"+string+"%' or title LIKE '%"+string+"%' or location LIKE '%"
                +string+"%' or activityProfile LIKE '%"+string+"%' or sponsorID LIKE '%"+string+"%' or type LIKE '%"+string+"%';";
        select(activityList,selectSql);
        return activityList;
    }
    //通过类型关键字查找活动
    public List<Activity> getActivityByType(String type){
        List<Activity> activityList=new ArrayList<>();
        String selectSql="select * from activity where type='"+type+"';";
        select(activityList,selectSql);
        return activityList;
    }
    //通过类型关键字查找活动
    public List<Activity> getActivityByActivityID(String activityID){
        List<Activity> activityList=new ArrayList<>();
        String selectSql="select * from activity where activityID='"+activityID+"';";
        select(activityList,selectSql);
        return activityList;
    }
    public List<Activity> getActivityBySponsorID(String sponsorID){
        List<Activity> activityList=new ArrayList<>();
        String selectSql="select * from activity where sponsorID='"+sponsorID+"';";
        select(activityList,selectSql);
        return activityList;
    }
    public void select(List<Activity> activityList,String selectSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Activity activity=new Activity(resultSet.getString("activityID"),resultSet.getString("title"),
                        resultSet.getString("startTime"),resultSet.getString("endTime"),resultSet.getString("registrationStartTime"),
                        resultSet.getString("registrationEndTime"),resultSet.getString("location"),resultSet.getString("activityProfile"),
                        resultSet.getString("sponsorID"),resultSet.getString("image"),resultSet.getString("type"));
                // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
                activityList.add(activity);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
    }
    public void selectRegistrationActivity(List<Activity> activityList,String selectSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Activity activity=new Activity(resultSet.getString("activityID"),resultSet.getString("title"),
                        resultSet.getString("startTime"),resultSet.getString("endTime"),resultSet.getString("registrationStartTime"),
                        resultSet.getString("registrationEndTime"),resultSet.getString("location"),resultSet.getString("activityProfile"),
                        resultSet.getString("sponsorID"),resultSet.getString("image"),resultSet.getString("type"));
                // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String time=df.format(new Date());// new Date()为获取当前系统时间
                if(DBUtill.compare(activity.getRegistrationEndTime(),time)){
                    activityList.add(activity);
                }
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
    }

    //紫微要的函数
    public String starApplyActivity(String type){
        //所有活动
        List<Activity> activityList=new ArrayList<>();
        //收藏的活动
        List<Activity> activityList1=new ArrayList<>();
        //报名的活动
        List<Activity> activityList2=new ArrayList<>();
        String selectSql="select * from activity where type='"+type+"';";
        String selectSql1="select *\n" +
                "from activity a,stu_collect_activity sca\n" +
                "where a.activityId=sca.activityId and a.type='"+type+"';";
        String selectSql2="select *\n" +
                "from activity a,stu_apply_activity saa\n" +
                "where a.activityId=saa.activityId and a.type='"+type+"';";
        select(activityList,selectSql);
        select(activityList1,selectSql1);
        select(activityList2,selectSql2);
        ActivityDao activityDao = new ActivityDaoImpl();
        JSONArray array = JSONArray.fromObject(activityList);
        JSONArray array1 = JSONArray.fromObject(activityList1);
        JSONArray array2 = JSONArray.fromObject(activityList2);
        String strArray = array.toString();
        String strArray1=array1.toString();
        String strArray2=array2.toString();
        return strArray+"\t\r\t\r"+strArray1+"\t\r\t\r"+strArray2;
    }
}

