package entity;

/**
 * Created by lenovo on 2018/7/4.
 */

public class Sponsor {
    private String sponsorID;
    private String sponsorName;
    private String phoneNum;
    private String password;
    private String introduction;
    public Sponsor(String sponsorID,String sponsorName,String phoneNum,String password,String introduction){
        setSponsorID(sponsorID);
        setSponsorName(sponsorName);
        setPhoneNum(phoneNum);
        setPassword(password);
        setIntroduction(introduction);
    }
    public void setSponsorID(String sponsorID) {
        this.sponsorID = sponsorID;
    }
    public String getSponsorID() {
        return sponsorID;
    }
    public void setSponsorName(String spponsorName) {
        this.sponsorName = spponsorName;
    }
    public String getSponsorName() {
        return sponsorName;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getIntroduction() {
        return introduction;
    }
}
