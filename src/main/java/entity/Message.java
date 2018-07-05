package entity;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Message {
    private String messageID;
    private String content;
    private String studentID;
    private String activityID;
    private Date time;

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }
    public String getMessageID() {
        return messageID;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }
    public String getActivityID() {
        return activityID;
    }
    public void setTime(Date time){
        this.time=time;
    }
    public Date getTime() {
        return time;
    }
}
