package entity;

/**
 * Created by lenovo on 2018/7/13.
 */
public class StuApplyResult {
    private String studentID;
    private String activityID;
    private String activityName;
    private String state;
    public StuApplyResult(String studentID,String activityID,String activityName,String state){
        setStudentID(studentID);
        setActivityID(activityID);
        setActivityName(activityName);
        setState(state);
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getActivityID() {
        return activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getState() {
        return state;
    }

    public String getStudentID() {
        return studentID;
    }
}
