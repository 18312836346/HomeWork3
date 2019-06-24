package com.example.homework.dao;


import com.example.homework.model.AdmCount;
import com.example.homework.model.AdmInfo;

public interface AdmDao {


    //1.查询
    AdmInfo selectAdmInfo(String userName);//查询账号
    AdmCount selectAdmCount(String userName);//查询个人信息

    //2.修改
    void update(AdmCount admCount);//修改账号
    void update(AdmInfo admInfo);//修改个人信息

    //3.插入
    void insert(AdmCount admCount);//插入账户
    void insert(AdmInfo admInfo);//插入个人信息

    //4.删除
    void delete(AdmCount admCount);//删除账号
    void delete(AdmInfo admInfo);//删除个人信息

}
