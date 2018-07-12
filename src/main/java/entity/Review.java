package entity;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Review {
    private String reviewID;
    private String title;
    private String essay;
    private String activityID;
    private String sponsorID;
    public Review(String reviewID,String title,String essay,String activityID,String sponsorID){
        setReviewID(reviewID);
        setTitle(title);
        setEssay(essay);
        setActivityID(activityID);
        setSponsorID(sponsorID);
    }
    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }
    public String getReviewID() {
        return reviewID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setEssay(String essay) {
        this.essay = essay;
    }
    public String getEssay() {
        return essay;
    }
    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }
    public String getActivityID() {return activityID;}
    public void setSponsorID(String sponsorID) {
        this.sponsorID = sponsorID;
    }
    public String getSponsorID() {
        return sponsorID;
    }
}
