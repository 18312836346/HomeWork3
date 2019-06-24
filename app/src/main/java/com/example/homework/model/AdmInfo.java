package com.example.homework.model;

import java.io.Serializable;

public class AdmInfo implements Serializable {
    public static final String TBL_ADMINFO = "create table  if not exists t_adminfo(" +
            "id integer primary key autoincrement, " +
            "name varchar(20) ," +
            "job_number integer ," +
            "phone integer ,"+
            "username varchar(20))";


    private int id;
    private String admName;
    private String userName;
    private int admJobNumber;
    private int admPhone;

    @Override
    public String toString() {
        return "AdmInfo{" +
                "id=" + id +
                ", admName='" + admName + '\'' +
                ", userName='" + userName + '\'' +
                ", admJobNumber=" + admJobNumber +
                ", admPhone=" + admPhone +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAdmJobNumber() {
        return admJobNumber;
    }

    public void setAdmJobNumber(int admJobNumber) {
        this.admJobNumber = admJobNumber;
    }

    public int getAdmPhone() {
        return admPhone;
    }

    public void setAdmPhone(int admPhone) {
        this.admPhone = admPhone;
    }
}