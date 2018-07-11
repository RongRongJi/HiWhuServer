package dao;

import entity.Sponsor;
import java.util.List;

/**
 * Created by lenovo on 2018/7/5.
 */
public interface SponsorDao {
    public List<Sponsor> show();
    //获取当前主办方的信息
    public Sponsor getSponsor(String sponsorID);
    public int deleteSponsor(String sponsorID);
    public int addSponsor(String sponsorID,String sponsorName,String phoneNum,String password,String introduction,String headProtrait);
}
