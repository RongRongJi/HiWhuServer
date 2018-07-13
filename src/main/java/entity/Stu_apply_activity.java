package entity;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Stu_apply_activity {
    private String studentID;
    private String activityID;
    private String time;
    private String state;
    private String studentName;
    private String phoneNum;
    private String qqNum;
    public Stu_apply_activity(String studentID,String activityID,String time,String state,String studentName,String phoneNum,String qqNum){
        setStudentID(studentID);
        setActivityID(activityID);
        setTime(time);
        setState(state);
        setStudentName(studentName);
        setPhoneNum(phoneNum);
        setQqNum(qqNum);
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
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getQqNum() {
        return qqNum;
    }
}
