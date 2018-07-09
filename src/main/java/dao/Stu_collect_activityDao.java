package dao;

import entity.Stu_apply_activity;
import entity.Stu_collect_activity;

import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
public interface Stu_collect_activityDao {
    public int addCollect(String studentID,String activityID);
    public List<Stu_collect_activity> getActivityByStudentID(String studentID);
    public int deleteCollect(String studentID,String activityID);
    public List<Stu_collect_activity> getActivityByStudentIDAndActivityID(String studentID,String activityID);
}
