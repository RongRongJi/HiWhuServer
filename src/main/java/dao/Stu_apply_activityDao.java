package dao;

import entity.Activity;
import entity.Stu_apply_activity;
import entity.Student;

import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
public interface Stu_apply_activityDao {
    public int addApply(String studentID,String activityID,String time,String state);
    public List<Activity> getActivityByStudentID(String studentID);
    public List<Student> getActivityByActivityID(String activityID);
    public List<Activity> getActivityByStudentIDAndState2(String studentID);
    public int deleteApply(String studentID,String activityID);
    public List<Stu_apply_activity> getActivityByStudentIDAndActivityID(String studentID,String activityID);
    public int passApply(String studentID,String activityID);
    public int rejectApply(String studentID,String activityID);
}
