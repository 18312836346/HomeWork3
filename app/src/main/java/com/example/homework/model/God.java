package com.example.homework.model;

import java.io.Serializable;

public class God implements Serializable {

    public static  String TBL_GOD="create table t_gods(" +
            "id integer primary key autoincrement not null," +
            "gods_number varchar(100) not null," +
            "gods_name varchar(100) not null," +
            "person_name varchar(100) not null," +
            "person_phone integer(1000) not null," +
            "gods_go_out_time varchar(200) not null," +
            "gods_return_time varchar(200) not null)";

    int id;
    String godsNumber;
    String godsName;
    String personName;
    int personPhone;
    String godsGoOutTime;
    String godsReturnTime;


    public God(){

    }

    public God(int id, String godsNumber, String godsName, String personName,
               int personPhone, String godsGoOutTime, String godsReturnTime) {
        this.id = id;
        this.godsNumber = godsNumber;
        this.godsName = godsName;
        this.personName = personName;
        this.personPhone = personPhone;
        this.godsGoOutTime = godsGoOutTime;
        this.godsReturnTime = godsReturnTime;
    }

    public static String getTblGod() {
        return TBL_GOD;
    }

    public static void setTblGod(String tblGod) {
        TBL_GOD = tblGod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGodsNumber() {
        return godsNumber;
    }

    public void setGodsNumber(String godsNumber) {
        this.godsNumber = godsNumber;
    }

    public String getGodsName() {
        return godsName;
    }

    public void setGodsName(String godsName) {
        this.godsName = godsName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(int personPhone) {
        this.personPhone = personPhone;
    }

    public String getGodsGoOutTime() {
        return godsGoOutTime;
    }

    public void setGodsGoOutTime(String godsGoOutTime) {
        this.godsGoOutTime = godsGoOutTime;
    }

    public String getGodsReturnTime() {
        return godsReturnTime;
    }

    public void setGodsReturnTime(String godsReturnTime) {
        this.godsReturnTime = godsReturnTime;
    }

    @Override
    public String toString() {
        return "God{" +
                "id=" + id +
                ", godsNumber='" + godsNumber + '\'' +
                ", godsName='" + godsName + '\'' +
                ", personName='" + personName + '\'' +
                ", personPhone=" + personPhone +
                ", godsGoOutTime='" + godsGoOutTime + '\'' +
                ", godsReturnTime='" + godsReturnTime + '\'' +
                '}';
    }
}
