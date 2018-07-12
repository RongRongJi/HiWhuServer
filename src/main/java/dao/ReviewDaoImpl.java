package dao;

import database.DBUtill;
import entity.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/7/12.
 */
public class ReviewDaoImpl implements ReviewDao {
    public List<Review> getReviewByActivityID(String activityID){
        List<Review> reviewList=new ArrayList<>();
        String selectSql="select * from review where activityID='"+activityID+"';";
        select(reviewList,selectSql);
        return reviewList;
    }
    public int addReview(String reviewID,String title,String essay,String activityID,String sponsorID){
        String insertSql="insert into review values('"+reviewID+"','"+title+"','"+essay+"','"+activityID+"','"+sponsorID+"');";
        System.out.print(insertSql);
        return DBUtill.insert(insertSql);
    }
    public int deleteReviewByReviewID(String reviewID){
        String deleteSql="delete from review where reviewID='"+reviewID+"';";
        System.out.print(deleteSql);
        return DBUtill.delete(deleteSql);
    }
    public void select(List<Review> reviewList,String selectSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Review review=new Review(resultSet.getString("reviewID"),resultSet.getString("title"),
                        resultSet.getString("essay"),resultSet.getString("activityID"),resultSet.getString("sponsorID"));
                reviewList.add(review);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
    }
    public int updateReview(String reviewID,String title,String essay){
        String updateSql="update review set title='"+title+"',essay='"+essay+"' where reviewID='"+reviewID+"';";
        System.out.print(updateSql);
        return DBUtill.update(updateSql);
    }
}

