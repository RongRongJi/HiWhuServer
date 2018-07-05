package entity;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Review {
    private String reviewID;
    private String title;
    private String essay;
    private String activity;

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
    public void setActivity(String activity) {
        this.activity = activity;
    }
    public String getActivity() {
        return activity;
    }
}
