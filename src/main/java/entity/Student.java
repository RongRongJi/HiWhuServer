package entity;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Student {
    private String studentID;
    private String userName;
    private String password;
    public Student(String studentID,String userName,String password){
        setStudentID(studentID);
        setUserName(userName);
        setPassword(password);
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
