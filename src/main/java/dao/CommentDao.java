package dao;

/**
 * Created by lenovo on 2018/7/10.
 */
public interface CommentDao {
    public int addComment(String fromUserID,String content,String commentID,String activityID);
    public int replyComment(String fromUserID,String toUserID,String content,String commentID,String activityID);
    public int deleteCommentByCommentID(String commentID);
}
