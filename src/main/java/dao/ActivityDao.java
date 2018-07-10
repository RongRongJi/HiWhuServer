package dao;

import entity.Activity;
import entity.Sponsor;

import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/7/7.
 */
public interface ActivityDao {
    //展示所有活动
    public List<Activity> show();
    //通过activityID删除活动
    public int deleteActivity(String activityID);
    //插入活动
    public int addActivity(String activityID, String title, String startTime, String endTime, String registrationStartTime, String registrationEndTime,
                           String location, String activityProfile, String sponsorID, String image,String type);
    //更新活动信息
    public int updateActivity(String activityID, String title, String startTime, String endTime, String registrationStartTime, String registrationEndTime,
                              String location, String activityProfile, String sponsorID, String image,String type);
    //添加活动图片
    public int addImage(String activityID, String image);
    //通过关键字查找活动
    public List<Activity> selectActivity(String string);
    public List<Activity> getActivityByActivityID(String activityID);
    public List<Activity> getActivityByType(String type);
    public List<Activity> getActivityBySponsorID(String sponsorID);
}
