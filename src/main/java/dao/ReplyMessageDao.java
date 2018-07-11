package dao;

import entity.ReplyMessage;

import java.util.List;

/**
 * Created by lenovo on 2018/7/11.
 */
public interface ReplyMessageDao {
    public List<ReplyMessage> getMessageByStudentID(String studentID);
    public int addRMessage(String rMessageID,String time,String content,String fromSponsorID,String toStudentID,String activityID,String commentID);
}
