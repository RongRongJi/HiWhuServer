package entity;

/**
 * Created by lenovo on 2018/7/10.
 */
public class Comment {
    private String fromUserID;
    private String refCommentID;
    private String content;
    private String activityID;
    private String commentID;
    private String time;
    public Comment(String fromUserID,String refCommentID,String content,String activityID,String commentID,String time){
        setActivityID(activityID);
        setContent(commentID);
        setContent(content);
        setFromUserID(fromUserID);
        setRefCommentID(refCommentID);
        setTime(time);
    }

    public void setFromUserID(String fromUserID) {
        this.fromUserID = fromUserID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRefCommentID(String toUsreID) {
        this.refCommentID = toUsreID;
    }

    public String getActivityID() {
        return activityID;
    }

    public String getCommentID() {
        return commentID;
    }

    public String getContent() {
        return content;
    }

    public String getFromUserID() {
        return fromUserID;
    }

    public String getRefCommentID() {
        return refCommentID;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
