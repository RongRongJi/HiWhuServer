package dao;

import database.DBUtill;
import entity.Sponsor;
import entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static database.DBUtill.delete;

/**
 * Created by lenovo on 2018/7/5.
 */
public class SponsorDaoImpl implements SponsorDao {
    public List<Sponsor> show(){
        List<Sponsor> sponsorList=new ArrayList<>();
        String selectSql="select * from sponsor";
        System.out.println();
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                Sponsor sponsor=new Sponsor(resultSet.getString("sponsorID"),
                        resultSet.getString("sponsorName"),resultSet.getString("phoneNum"),
                        resultSet.getString("password"), resultSet.getString("introduction"),
                        resultSet.getString("headProtrait"));
                // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
                System.out.println(sponsor.toString());
                sponsorList.add(sponsor);
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return sponsorList;
    }
    //获取当前主办方的信息
    public Sponsor getSponsor(String sponsorID){
        Sponsor sponsor = null;
        String selectSql="select * from sponsor where sponsorID='"+sponsorID+"'";
        System.out.println();
        try {
            Statement statement= DBUtill.getConnect().createStatement();
            ResultSet resultSet=statement.executeQuery(selectSql);
            while (resultSet.next()) {
                sponsor=new Sponsor(resultSet.getString("sponsorID"),resultSet.getString("sponsorName"),
                        resultSet.getString("phoneNum"), resultSet.getString("password"),
                        resultSet.getString("introduction"),resultSet.getString("headProtrait"));
                System.out.println(sponsor.toString());
            }
            System.out.println("查询成功");
            statement.close();
            DBUtill.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return sponsor;
    }


    public int deleteSponsor(String sponsorID){
        String deleteSql="delete sponsor where sponsorID='"+sponsorID+"'";
        System.out.println(deleteSql);
        return DBUtill.delete(deleteSql);
    }
    public int addSponsor(String sponsorID,String sponsorName,String phoneNum,String password,String introduction,String headProtrait){
        String insertSql="insert into sponsor(sponsorID,sponsorName,phoneNum,password,introduction,headProtrait) values ('"+sponsorID
                +"','"+sponsorName+"','"+phoneNum+"','"+password+"','"+introduction+"','"+headProtrait+"');";
        System.out.println(insertSql);
        return DBUtill.insert(insertSql);
    }
}
