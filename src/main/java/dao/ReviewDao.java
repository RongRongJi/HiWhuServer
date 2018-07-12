package dao;

import entity.Review;

import java.util.List;

/**
 * Created by lenovo on 2018/7/12.
 */
public interface ReviewDao {
    public List<Review> getReviewByActivityID(String activityID);
    public int addReview(String reviewID,String title,String essay,String activityID,String sponsorID);
    public int deleteReviewByReviewID(String reviewID);
    public int updateReview(String reviewID,String title,String essay);
}
