package dao;

import java.util.List;
import entity.*;
/**
 * Created by lsr on 2018/7/5.
 */
public interface StudentDao{
    public List<Student> show();
    public int deleteStudent(String studentID);
    public int addStudent(String studentID,String username,String password);
    public List<Student> selectStudent(String studentID);
}
