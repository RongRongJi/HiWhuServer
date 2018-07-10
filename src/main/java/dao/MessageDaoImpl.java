package dao;

import database.DBUtill;
import entity.Activity;
import entity.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/7/10.
 */
public class MessageDaoImpl implements MessageDao {
    public int addPassMessage(String messageID,String studentID,String activityID,String time){
        ActivityDao activityDao=new ActivityDaoImpl();
        Activity activity=activityDao.getActivityByActivityID(activityID).get(0);
        String insertSql="insert into message values ('"+messageID+"','您对于“"+activity.getTitle()+"”活动的申请已通过','"
                +studentID+"','"+activityID+"',str_to_date('"+time+"','%Y-%m-%d %H:%i:%s'));";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }

    public int addRejectMessage(String messageID,String studentID,String activityID,String time){
        ActivityDao activityDao=new ActivityDaoImpl();
        Activity activity=activityDao.getActivityByActivityID(activityID).get(0);
        String insertSql="insert into message values ('"+messageID+"','您对于“"+activity.getTitle()+"”活动的申请未通过','"
                +studentID+"','"+activityID+"',str_to_date('"+time+"','%Y-%m-%d %H:%i:%s'));";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }

    public List<Message> getMessageByStudentID(String studentID){
        List<Message> messageList=new ArrayList<>();
        String selectSql="select * from message where studentID='"+studentID+"';";
        select(messageList,selectSql);
        return messageList;
    }

    public void select(List<Message> messageList,String selectSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Message message=new Message(resultSet.getString("messageID"),resultSet.getString("content"),
                        resultSet.getString("studentID"),resultSet.getString("activityID"),
                        resultSet.getString("time"));
                // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
                messageList.add(message);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
    }
}
