package dao;

import database.DBUtill;
import entity.Stu_apply_activity;
import entity.Stu_collect_activity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/7/9.
 */
public class Stu_collect_activityDaoImpl implements Stu_collect_activityDao{
    //初次点击收藏活动
    public int addCollect(String studentID,String activityID){
        String insertSql="insert into stu_collect_activity values('"+studentID+"','"+activityID+"');";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }

    //查看“我的收藏”
    public List<Stu_collect_activity> getActivityByStudentID(String studentID){
        List<Stu_collect_activity> collectList=new ArrayList<>();
        String selectSql="select * from stu_collect_activity where studentID='"+studentID+"';";
        select(collectList,selectSql);
        return collectList;
    }

    //看是否已经收藏一个活动了（是否二次点击）
    public List<Stu_collect_activity> getActivityByStudentIDAndActivityID(String studentID,String activityID){
        List<Stu_collect_activity> collectList=new ArrayList<>();
        String selectSql="select * from stu_collect_activity where studentID='"+studentID+"' and activityID='"+activityID+"';";
        select(collectList,selectSql);
        return collectList;
    }

    //二次点击星星取消收藏
    public int deleteCollect(String studentID,String activityID){
        String deleteSql="delete from stu_collect_activity where studentID='"+studentID+"' and activityID='"+activityID+"';";
        System.out.println(deleteSql);
        return DBUtill.insert(deleteSql);
    }

    public void select(List<Stu_collect_activity> collectList,String selectSql){
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Stu_collect_activity stu_collect_activity=new Stu_collect_activity(resultSet.getString("studentID"),
                        resultSet.getString("activityID"));
                // 将查询出的内容添加到list中
                collectList.add(stu_collect_activity);
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
