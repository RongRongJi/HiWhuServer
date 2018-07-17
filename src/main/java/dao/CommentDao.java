package dao;

import entity.Comment;
import entity.CommentAndReply;
import entity.CommentWithActivity;

import java.util.List;

/**
 * Created by lenovo on 2018/7/10.
 */
public interface CommentDao {
    public int addComment(String fromUserID, String content, String commentID, String activityID, String time);
    public int replyComment(String fromUserID, String refCommentID, String content, String commentID, String activityID, String time);
    public int deleteCommentByCommentID(String commentID);
    public List<Comment> getCommentByCommentID(String commentID);
    public List<CommentAndReply> getCommentAndReplyByActivityID(String activityID);
    public List<CommentWithActivity> getCommentCount(String sponsorID);
}
