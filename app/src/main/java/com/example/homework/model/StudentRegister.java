package com.example.homework.model;

import java.io.Serializable;

public class StudentRegister implements Serializable {
    public static final String TBL_ST_REGISTER= "create table t_st_register(" +
            "id integer primary key autoincrement," +
            "student_name varchar(100) ,"  +
            "student_sex varchar(100) ,"  +
            "student_number integer(20) ," +
            "student_phone integer(20) ," +
            "student_xueyuan varchar(100)," +
            "destination varchar(100)," +
            "student_class varchar(100)," +
            "student_room varchar(100)," +
            "intotime varchar(100) ," +
            "outtime  varchar(100))";


    private int id;
    private String studentName;
    private String studentSex;
    private int studentNumber;
    private int studentPhone;
    private String studentXueyuan;
    private String destination;
    private String studentClass;
    private String studentRoom;
    private String intotime;
    private String outtime;


    public  StudentRegister(){

    }

    public StudentRegister(int id, String studentName, String studentSex, int studentNumber, int studentPhone, String studentXueyuan,
                           String destination, String studentClass, String studentRoom, String intotime, String outtime) {
        this.id = id;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentNumber = studentNumber;
        this.studentPhone = studentPhone;
        this.studentXueyuan = studentXueyuan;
        this.destination = destination;
        this.studentClass = studentClass;
        this.studentRoom = studentRoom;
        this.intotime = intotime;
        this.outtime = outtime;
    }

    public static String getTblStRegister() {
        return TBL_ST_REGISTER;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(int studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentXueyuan() {
        return studentXueyuan;
    }

    public void setStudentXueyuan(String studentXueyuan) {
        this.studentXueyuan = studentXueyuan;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentRoom() {
        return studentRoom;
    }

    public void setStudentRoom(String studentRoom) {
        this.studentRoom = studentRoom;
    }

    public String getIntotime() {
        return intotime;
    }

    public void setIntotime(String intotime) {
        this.intotime = intotime;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    @Override
    public String toString() {
        return "StudentRegister{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentNumber=" + studentNumber +
                ", studentPhone=" + studentPhone +
                ", studentXueyuan='" + studentXueyuan + '\'' +
                ", destination='" + destination + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studentRoom='" + studentRoom + '\'' +
                ", intotime='" + intotime + '\'' +
                ", outtime='" + outtime + '\'' +
                '}';
    }
}
