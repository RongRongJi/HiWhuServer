package dao;

import database.DBUtill;
import entity.LeaveMessage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/7/11.
 */
public class LeaveMessageDaoImpl implements LeaveMessageDao {
    public List<LeaveMessage> getMessageBySponsorID(String sponsorID){
        List<LeaveMessage> lMessageList=new ArrayList<>();
        String selectSql="select * from leavemessage where toSponsorID='"+sponsorID+"';";
        System.out.print(selectSql);
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                LeaveMessage leaveMessage=new LeaveMessage(resultSet.getString("lMessageID"),resultSet.getString("time"),
                        resultSet.getString("content"),resultSet.getString("fromStudentID"),
                        resultSet.getString("toSponsorID"),resultSet.getString("activityID"),resultSet.getString("commentID"));
                // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
                lMessageList.add(leaveMessage);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return lMessageList;
    }
    public int addLMessage(String lMessageID, String time, String content, String fromStudentID, String toSponsorID, String activityID,String commentID){
        String insertSql="insert into leavemessage values('"+lMessageID+"','"+time+"','"+content+"','"+fromStudentID+"','"+toSponsorID+"','"
                +activityID+"','"+commentID+"');";
        System.out.print(insertSql);
        return DBUtill.insert(insertSql);
    }
}
