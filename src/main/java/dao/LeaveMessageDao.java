package dao;

import entity.LeaveMessage;

import java.util.List;

/**
 * Created by lenovo on 2018/7/11.
 */
public interface LeaveMessageDao {
    public List<LeaveMessage> getMessageBySponsorID(String sponsorID);
    public int addLMessage(String lMessageID, String time, String content, String fromStudentID, String toSponsorID, String activityID,String commentID);
}
