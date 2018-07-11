package dao;

import database.DBUtill;

/**
 * Created by lenovo on 2018/7/10.
 */
public class CommentDaoImpl implements CommentDao {
    public int addComment(String fromUserID,String content,String activityID,String commentID){
        String insertSql="insert into comment(fromUserID,content,activityID,commentID) values('"+fromUserID
                +"','"+content+"','"+activityID+"','"+commentID+"');";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }
    public int replyComment(String fromUserID,String toUserID,String content,String activityID,String commentID){
        String insertSql="insert into comment(fromUserID,toUserID,content,activityID,commentID) values('"+fromUserID
                +"','"+toUserID+"','"+content+"','"+activityID+"','"+commentID+"');";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }
    public int deleteCommentByCommentID(String commentID){
        String deleteSql="delete from comment where  commentID='"+commentID+"';";
        System.out.print(deleteSql);
        return DBUtill.delete(deleteSql);
    }
}
