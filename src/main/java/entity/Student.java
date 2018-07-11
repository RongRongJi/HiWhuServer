package entity;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Student {
    private String studentID;
    private String userName;
    private String password;
    private String headProtrait;
    public Student(String studentID,String userName,String password,String headProtrait){
        setStudentID(studentID);
        setUserName(userName);
        setPassword(password);
        setHeadProtrait(headProtrait);
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

    public void setHeadProtrait(String headProtrait) {
        this.headProtrait = headProtrait;
    }

    public String getHeadProtrait() {
        return headProtrait;
    }
}
