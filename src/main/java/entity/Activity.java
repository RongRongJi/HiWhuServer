package entity;

import java.util.Date;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Activity {
    private String activityID;
    private String title;
    private String startTIme;
    private String endTime;
    private String registrationStartTime;
    private String registrationEndTime;
    private String location;
    private String activityProfile;
    private String sponsorID;
    private String image;
    //1代表“竞赛”,2代表“体育”，3代表“”，4代表“”，5代表“”，6代表“”
    private String type;
    public Activity(String activityID,String title,String startTime,String endTime,String registrationStartTime,String registrationEndTime,
                    String location,String activityProfile,String sponsorID,String image,String type){
        setActivityID(activityID);
        setTitle(title);
        setStartTIme(startTime);
        setEndTime(endTime);
        setRegistrationStartTime(registrationStartTime);
        setRegistrationEndTime(registrationEndTime);
        setLocation(location);
        setActivityProfile(activityProfile);
        setSponsorID(sponsorID);
        setImage(image);
        setType(type);
    }
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
    public void setStartTIme(String startTIme) {
        this.startTIme = startTIme;
    }
    public String getStartTIme() {
        return startTIme;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setRegistrationStartTime(String registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
    }
    public String getRegistrationStartTime() {
        return registrationStartTime;
    }
    public void setRegistrationEndTime(String getRegistrationEndTime) {
        this.registrationEndTime = getRegistrationEndTime;
    }
    public String getRegistrationEndTime() {
        return registrationEndTime;
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
    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}