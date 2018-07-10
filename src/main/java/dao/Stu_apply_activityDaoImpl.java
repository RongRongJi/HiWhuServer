package dao;

import database.DBUtill;
import entity.Activity;
import entity.Stu_apply_activity;
import entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
public class Stu_apply_activityDaoImpl implements Stu_apply_activityDao {
    public int addApply(String studentID,String activityID,String time,String state){
        String insertSql="insert into stu_apply_activity values ('"+studentID+"','"+activityID+"',str_to_date('"
                +time+"','%Y-%m-%d %H:%i:%s'),'"+state+"');";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);

    }
    //学生查看自己未审核的活动
    public List<Activity> getActivityByStudentID(String studentID){
        List<Activity> activityList=new ArrayList<>();
        String selectSql="select * from stu_apply_activity where studentID='"+studentID+"' and state='1';";
        selectActivity(activityList,selectSql);
        return activityList;
    }

    //学生查看自己已经审核通过的活动（待参加）
    public List<Activity> getActivityByStudentIDAndState2(String studentID){
        List<Activity> activityList=new ArrayList<>();
        String selectSql="select * from stu_apply_activity where studentID='"+studentID+"' and state='2';";
        selectActivity(activityList,selectSql);
        return activityList;
    }

    //找到某一个活动中没有审核的报名的人（活动主办方查看未审核人员名单）
    public List<Student> getActivityByActivityID(String activityID){
        List<Student> studentList=new ArrayList<>();
        String selectSql="select * from stu_apply_activity where activityID='"+activityID+"' and state='1';";
        selectStudent(studentList,selectSql);
        return studentList;
    }

    //找到已经报名的活动，防止重复报名
    public List<Stu_apply_activity> getActivityByStudentIDAndActivityID(String studentID,String activityID){
        List<Stu_apply_activity> applyList=new ArrayList<>();
        String selectSql="select * from stu_apply_activity where studentID='"+studentID+"' and activityID='"+activityID+"';";
        select(applyList,selectSql);
        return applyList;
    }

    //删除报名信息，参加过的活动 时要用到（可以在select的时候引发触发器）
    public int deleteApply(String studentID,String activityID){
        String deleteSql="delete from stu_apply_activity where studentID='"+studentID+"' and activityID='"+activityID+"';";
        System.out.println(deleteSql);
        return DBUtill.insert(deleteSql);
    }

    //活动主办方通过一个活动报名
    public int passApply(String studentID,String activityID){
        String updateSql="update stu_apply_activity set state='2' where studentID='"+studentID+"' and activityID='"+activityID+"';";
        System.out.println(updateSql);
        return DBUtill.update(updateSql);
    }

    //活动主办方拒绝一个活动报名
    public int rejectApply(String studentID,String activityID){
        String updateSql="update stu_apply_activity set state='3' where studentID='"+studentID+"' and activityID='"+activityID+"';";
        System.out.println(updateSql);
        return DBUtill.update(updateSql);
    }

    public void selectActivity(List<Activity> activityList,String selectSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                String activityID= resultSet.getString("activityID");
                ActivityDao activityDao=new ActivityDaoImpl();
                Activity activity=activityDao.getActivityByActivityID(activityID).get(0);
                activityList.add(activity);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
    }

    public void selectStudent(List<Student> studentList,String selectSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                String studentID= resultSet.getString("studentID");
                StudentDao studentDao=new StudentDaoImpl();
                Student student=studentDao.selectStudent(studentID).get(0);
                studentList.add(student);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
    }
    public void select(List<Stu_apply_activity> applyList,String selectSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Stu_apply_activity stu_apply_activity=new Stu_apply_activity(resultSet.getString("studentID"),
                        resultSet.getString("activityID"), resultSet.getString("time"),
                        resultSet.getString("state"));
                // 将查询出的内容添加到list中
                applyList.add(stu_apply_activity);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
    }
}
