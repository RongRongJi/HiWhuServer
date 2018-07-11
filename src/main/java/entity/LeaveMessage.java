package entity;

/**
 * Created by lenovo on 2018/7/11.
 */
public class LeaveMessage {
    private String lMessageID;
    private String time;
    private String content;
    private String fromStudentID;
    private String toSponsorID;
    private String activityID;
    private String commentID;
    public LeaveMessage(String lMessageID, String time, String content, String fromStudentID, String toSponsorID, String activityID,String commentID){
        setTime(time);
        setContent(content);
        setFromStudentID(fromStudentID);
        setToSponsorID(toSponsorID);
        setlMessageID(lMessageID);
        setActivityID(activityID);
        setCommentID(commentID);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFromStudentID(String fromStudentID) {
        this.fromStudentID = fromStudentID;
    }

    public void setlMessageID(String lMessageID) {
        this.lMessageID = lMessageID;
    }

    public void setToSponsorID(String toSponsorID) {
        this.toSponsorID = toSponsorID;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public String getFromStudentID() {
        return fromStudentID;
    }

    public String getlMessageID() {
        return lMessageID;
    }

    public String getToSponsorID() {
        return toSponsorID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getCommentID() {
        return commentID;
    }
}
