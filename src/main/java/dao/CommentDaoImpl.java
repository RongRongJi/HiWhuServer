package dao;

import database.DBUtill;
import entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/7/13.
 */
public class CommentDaoImpl implements CommentDao {
    public int addComment(String fromUserID,String content,String activityID,String commentID,String time){
        String insertSql="insert into comment(fromUserID,content,activityID,commentID,time) values('"+fromUserID
                +"','"+content+"','"+activityID+"','"+commentID+"','"+time+"');";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }
    public int replyComment(String fromUserID,String refCommentID,String content,String activityID,String commentID,String time){
        String insertSql="insert into comment(fromUserID,refCommentID,content,activityID,commentID,time) values('"+fromUserID
                +"','"+refCommentID+"','"+content+"','"+activityID+"','"+commentID+"','"+time+"');";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }
    public int deleteCommentByCommentID(String commentID){
        String deleteSql="delete from comment where  commentID='"+commentID+"';";
        System.out.print(deleteSql);
        return DBUtill.delete(deleteSql);
    }
    public List<Comment> getCommentByCommentID(String commentID){
        List<Comment> commentList=new ArrayList<>();
        String selectSql="select * from comment where commentID='"+commentID+"';";
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Comment comment=new Comment(resultSet.getString("fromUserID"),resultSet.getString("refCommentID"),
                        resultSet.getString("content"),resultSet.getString("activityID"),
                        resultSet.getString("commentID"),resultSet.getString("time"));
                commentList.add(comment);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return commentList;
    }
    public List<CommentAndReply> getCommentAndReplyByActivityID(String activityID){
        List<CommentAndReply> commentAndReplyList=new ArrayList<>();
        String selectSql="select *\n" +
                "from `comment` c1 left join`comment` c2 on c1.CommentID=c2.refCommentID\n" +
                "where ISNULL(c1.refCommentID) and c1.activityID='"+activityID+"';";
        System.out.println(selectSql);
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                String fromUserID=resultSet.getString("c1.fromUserID");
                System.out.println(fromUserID);
                StudentDao studentDao=new StudentDaoImpl();
                Student student=studentDao.selectStudent(fromUserID).get(0);
                List<Reply> replyList=new ArrayList<>();
                System.out.println(resultSet.getString("c2.fromUserID"));
                if(resultSet.getString("c2.fromUserID")!=null){
                    String fromUserID1=resultSet.getString("c2.fromUserID");
                    SponsorDao sponsorDao=new SponsorDaoImpl();
                    Sponsor sponsor=sponsorDao.getSponsor(fromUserID1);
                    System.out.println(sponsor.getSponsorName()+" "+resultSet.getString("c2.content")+" "+resultSet.getString("c2.time"));
                    Reply reply=new Reply(sponsor.getSponsorName(),resultSet.getString("c2.content"),resultSet.getString("c2.time"));
                    replyList.add(reply);
                }
                CommentAndReply commentAndReply=new CommentAndReply(resultSet.getString("c1.commentID"),fromUserID,student.getUserName(),
                        student.getHeadProtrait(),resultSet.getString("c1.content"),resultSet.getString("c1.activityID"),
                        resultSet.getString("c1.time"),replyList);
                commentAndReplyList.add(commentAndReply);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return commentAndReplyList;
    }

    public List<CommentWithActivity> getCommentCount(String sponsorID){
        List<CommentWithActivity> list = new ArrayList<>();
        String sql ="select count(*),c.activityID,title from comment c,activity a,sponsor s\n" +
                "where c.activityID is not null\n" +
                "and c.activityID=a.activityID\n" +
                "and refCommentID is null\n"+
                "and a.sponsorID=s.sponsorID\n" +
                "and s.sponsorID='"+sponsorID+"'\n" +
                "group by c.activityID;";
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()) {
                CommentWithActivity comment=new CommentWithActivity();
                comment.setCount(resultSet.getInt(1));
                comment.setActivityID(resultSet.getString(2));
                comment.setTitle(resultSet.getString(3));
                list.add(comment);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }

        return list;
    }
}