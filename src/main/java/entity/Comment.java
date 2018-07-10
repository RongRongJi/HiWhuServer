package entity;

/**
 * Created by lenovo on 2018/7/10.
 */
public class Comment {
    private String fromUserID;
    private String toUsreID;
    private String content;
    private String activityID;
    private String commentID;
    public Comment(String fromUserID,String toUsreID,String content,String activityID,String commentID){
        setActivityID(activityID);
        setContent(commentID);
        setContent(content);
        setFromUserID(fromUserID);
        setToUsreID(toUsreID);
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

    public void setToUsreID(String toUsreID) {
        this.toUsreID = toUsreID;
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

    public String getToUsreID() {
        return toUsreID;
    }
}
