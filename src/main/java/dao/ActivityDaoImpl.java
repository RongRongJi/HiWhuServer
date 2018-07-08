package dao;

import database.DBUtill;
import entity.Activity;
import entity.Sponsor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Activity activity=new Activity(resultSet.getString("activityID"),resultSet.getString("title"),
                        resultSet.getString("startTime"),resultSet.getString("endTime"),resultSet.getString("registrationStartTime"),
                        resultSet.getString("registrationEndTime"),resultSet.getString("location"),resultSet.getString("activityProfile"),
                        resultSet.getString("sponsorID"),resultSet.getBytes("image"));
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
                           String location,String activityProfile,String sponsorID,byte[] image){
        String insertSql="insert into activity values ('"+activityID+"','"+title+"',str_to_date('"+startTime+"','%Y-%m-%d %H:%i:%s')," +
                "str_to_date('"+endTime+"','%Y-%m-%d %H:%i:%s'),str_to_date('"+registrationStartTime +"','%Y-%m-%d %H:%i:%s')," +
                "str_to_date('"+registrationEndTime+"','%Y-%m-%d %H:%i:%s'),'"+location+"','"+activityProfile+"','"
                +sponsorID+"',"+image+");";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }
    //更新活动信息
    public int updateActivity(String activityID,String title,String startTime,String endTime,String registrationStartTime,String registrationEndTime,
                                         String location,String activityProfile,String sponsorID,byte[] image){
        String updateSql="update activity set title='"+title+"',startTime=str_to_date('"+startTime+"','%Y-%m-%d %H:%i:%s')," +
                "endTime=str_to_date('"+endTime+"','%Y-%m-%d %H:%i:%s')," +
                "registrationStartTime=str_to_date('"+registrationStartTime+"','%Y-%m-%d %H:%i:%s')," +
                "registrationEndTime=str_to_date('"+registrationEndTime+"','%Y-%m-%d %H:%i:%s'),location='"
                +location+"',activityProfile='"+activityProfile+"',sponsorID='"+sponsorID+"',image="+image+
                " where activityID='"+activityID+"';";
        System.out.println(updateSql);
        return DBUtill.update(updateSql);
    }
    //通过关键字查找活动
    public List<Activity> selectActivity(String string){
        return null;
    }
}
