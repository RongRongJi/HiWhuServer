package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import database.DBUtill;
import entity.*;
/**
 * Created by lenovo on 2018/7/5.
 */
public class StudentDaoImpl implements StudentDao {
    public List<Student> show(){
        List<Student> studentList=new ArrayList<> ();
        String selectSql="select * from Student";
        System.out.println();
        select(studentList,selectSql);
        return studentList;
    }
    //获取当前学生用户的信息
    public Student getStudent(String studentID){
        Student student = null;
        String selectSql="select * from student where studentID='"+studentID+"'";
        System.out.println();
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                student = new Student(resultSet.getString("studentID"),resultSet.getString("userName"),
                        resultSet.getString("password"),resultSet.getString("headProtrait"));
                System.out.println(student.toString());
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return student;
    }
    public int deleteStudent(String studentID){
        String deleteSql="delete Student where studentID='"+studentID+"'";
        System.out.println(deleteSql);
        return DBUtill.delete(deleteSql);
    }
    public int addStudent(String studentID,String username,String password,String headProtrait){
        String insertSql="insert into student(studentId,userName,password,headProtrait) values ('"+studentID+"','"+username+
                "','"+password+"','"+headProtrait+"');";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }
    public List<Student> selectStudent(String studentID){
        List<Student> studentList=new ArrayList<> ();
        String selectSql="select * from student where studentID='"+studentID+"';";
        System.out.println();
        select(studentList,selectSql);
        return studentList;
    }

    public void select(List<Student> studentList,String selectSql) {
        try {
        Statement statement= DBUtill.getConnect().createStatement();
        ResultSet resultSet=statement.executeQuery(selectSql);
        while (resultSet.next()) {
        Student stu=new Student(resultSet.getString("studentID"),resultSet.getString("userName"),
                resultSet.getString("password"),resultSet.getString("headProtrait"));
        // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
        System.out.println(stu.toString());
        studentList.add(stu);
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
