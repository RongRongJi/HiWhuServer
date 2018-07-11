package entity;

/**
 * Created by lenovo on 2018/7/11.
 */
public class ReplyMessage {
    private String rMessageID;
    private String time;
    private String content;
    private String fromSponsorID;
    private String toStudentID;
    private String activityID;
    private String commentID;
    public ReplyMessage(String rMessageID, String time, String content, String fromSponsorID, String toStudentID, String activityID,String commentID){
        setrMessageID(rMessageID);
        setContent(content);
        setFromSponsorID(fromSponsorID);
        setToStudentID(toStudentID);
        setTime(time);
        setActivityID(activityID);
        setCommentID(commentID);
    }
    public void setContent(String content) {
        this.content = content;
    }

    public void setFromSponsorID(String fromSponsorID) {
        this.fromSponsorID = fromSponsorID;
    }

    public void setrMessageID(String rMessageID) {
        this.rMessageID = rMessageID;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setToStudentID(String toStudentID) {
        this.toStudentID = toStudentID;
    }

    public String getContent() {
        return content;
    }

    public String getFromSponsorID() {
        return fromSponsorID;
    }

    public String getrMessageID() {
        return rMessageID;
    }

    public String getTime() {
        return time;
    }

    public String getToStudentID() {
        return toStudentID;
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
