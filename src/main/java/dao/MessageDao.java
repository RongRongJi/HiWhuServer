package dao;

import entity.Message;

import java.util.List;

/**
 * Created by lenovo on 2018/7/10.
 */
public interface MessageDao {
    public int addPassMessage(String messageID,String studentID,String activityID,String time);
    public int addRejectMessage(String messageID,String studentID,String activityID,String time);
    public List<Message> getMessageByStudentID(String studentID);
}
