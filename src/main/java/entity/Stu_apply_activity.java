package entity;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Stu_apply_activity {
    private String studentID;
    private String activityID;
    private Date time;
    private String state;

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
    public void setTime(Date time) {
        this.time = time;
    }
    public Date getTime() {
        return time;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
