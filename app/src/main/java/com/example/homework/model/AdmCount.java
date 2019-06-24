package com.example.homework.model;

import java.io.Serializable;

public class AdmCount implements Serializable {

    public static final String TBL_ADMCOUNT = "create table  if not exists t_admcount(" +
            "id integer primary key autoincrement, " +
            "username varchar(20) ," +
            "password integer )";

    private int id;
    private String userName;
    private String passWord;

    @Override
    public String toString() {
        return "AdmCount{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
