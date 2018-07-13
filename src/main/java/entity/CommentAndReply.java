package entity;

import java.util.List;

/**
 * Created by lenovo on 2018/7/13.
 */
public class CommentAndReply {
    private String commentID;
    private String userID;
    private String userName;
    private String userHeadProtrait;
    private String content;
    private String activityID;
    private String time;
    private List<Reply> replyList;
    public CommentAndReply(String commentID,String userID,String userName,String userHeadProtrait,String content,String activityID,String time,List<Reply> replyList){
        setCommentID(commentID);
        setUserID(userID);
        setUserName(userName);
        setUserHeadProtrait(userHeadProtrait);
        setContent(content);
        setActivityID(activityID);
        setTime(time);
        setReplyList(replyList);
    }

    public List<Reply> getReplyList() {
        return replyList;
    }


    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public String getUserHeadProtrait() {
        return userHeadProtrait;
    }

    public void setUserHeadProtrait(String userHeadProtrait) {
        this.userHeadProtrait = userHeadProtrait;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
