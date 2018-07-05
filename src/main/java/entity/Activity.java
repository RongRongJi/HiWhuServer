package entity;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Activity {
    private String activityID;
    private String title;
    private Date startTIme;
    private Date endTime;
    private Date registrationStartTime;
    private Date getRegistrationEndTime;
    private String location;
    private String activityProfile;
    private String sponsorID;
    private String reviewID;
    private byte[] image;

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }
    public String getActivityID() {
        return activityID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setStartTIme(Date startTIme) {
        this.startTIme = startTIme;
    }
    public Date getStartTIme() {
        return startTIme;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setRegistrationStartTime(Date registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
    }
    public Date getRegistrationStartTime() {
        return registrationStartTime;
    }
    public void setGetRegistrationEndTime(Date getRegistrationEndTime) {
        this.getRegistrationEndTime = getRegistrationEndTime;
    }
    public Date getGetRegistrationEndTime() {
        return getRegistrationEndTime;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }
    public void setActivityProfile(String activityProfile) {
        this.activityProfile = activityProfile;
    }
    public String getActivityProfile() {
        return activityProfile;
    }
    public void setSponsorID(String sponsorID) {
        this.sponsorID = sponsorID;
    }
    public String getSponsorID() {
        return sponsorID;
    }
    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }
    public String getReviewID() {
        return reviewID;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public byte[] getImage() {
        return image;
    }
}
