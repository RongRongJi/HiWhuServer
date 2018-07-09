package entity;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Stu_collect_activity {
    private String studentID;
    private String activityID;
    public Stu_collect_activity(String studentID,String activityID){
        setStudentID(studentID);
        setActivityID(activityID);
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
}
