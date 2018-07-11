package dao;

import database.DBUtill;
import entity.ReplyMessage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/7/11.
 */
public class ReplyMessageDaoImpl implements ReplyMessageDao {
    public List<ReplyMessage> getMessageByStudentID(String studentID){
        List<ReplyMessage> rMessageList=new ArrayList<>();
        String selectSql="select * from replymessage where toStudentID='"+studentID+"';";
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                ReplyMessage replyMessage=new ReplyMessage(resultSet.getString("rMessageID"),resultSet.getString("time"),
                        resultSet.getString("content"),resultSet.getString("fromSponsorID"),
                        resultSet.getString("toStudentID"),resultSet.getString("activityID"),resultSet.getString("commentID"));
                // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
                rMessageList.add(replyMessage);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return rMessageList;
    }
    public int addRMessage(String rMessageID,String time,String content,String fromSponsorID,String toStudentID,String activityID,String commentID){
        String insertSql="insert into replymessage values('"+rMessageID+"','"+time+"','"+content+"','"+fromSponsorID+"','"+toStudentID+"','"
                +activityID+"','"+commentID+"');";
        System.out.print(insertSql);
        return DBUtill.insert(insertSql);
    }
}
