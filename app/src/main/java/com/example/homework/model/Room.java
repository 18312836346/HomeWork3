package com.example.homework.model;

import java.io.Serializable;

public class Room implements Serializable {
    public static final String TBL_ROOM = "create table if not exists t_room(" +
            "id integer primary key autoincrement, " +
            "room_name varchar(20), " +
            "room_sex varchar(10), " +
            "expect_number integer, " +
            "real_number integer, " +
            "cost integer, " +
            "remark varchar(200))";


    private int id;
    private String roomName;
    private String roomSex;
    private int expectNumber;
    private int realNumber;
    private int cost;
    private String remark;

    public  Room(){

    }
    public Room(String roomName, String roomSex, int expectNumber, int realNumber, int cost, String remark) {
        this.roomName = roomName;
        this.roomSex = roomSex;
        this.expectNumber = expectNumber;
        this.realNumber = realNumber;
        this.cost = cost;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomSex() {
        return roomSex;
    }

    public void setRoomSex(String roomSex) {
        this.roomSex = roomSex;
    }

    public int getExpectNumber() {
        return expectNumber;
    }

    public void setExpectNumber(int expectNumber) {
        this.expectNumber = expectNumber;
    }

    public int getRealNumber() {
        return realNumber;
    }

    public void setRealNumber(int realNumber) {
        this.realNumber = realNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", roomSex='" + roomSex + '\'' +
                ", expectNumber=" + expectNumber +
                ", realNumber=" + realNumber +
                ", cost=" + cost +
                ", remark='" + remark + '\'' +
                '}';
    }
}
