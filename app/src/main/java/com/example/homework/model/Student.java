package com.example.homework.model;

import com.example.homework.ui.SafCountActivyty;

import java.io.Serializable;

public class Student implements Serializable {
    public static final String TBL_STUDENT= "create table if not exists t_student_info(" +
            "id integer primary key autoincrement, " +
            "username varchar(20)," +
            "student_name varchar(20)," +
            "student_sex varchar(10), " +
            "student_age integer," +
            "student_number integer ," +
            "student_classroom varchar(50), " +
            "student_institute varchar(50)," +
            "student_major varchar(50)," +
            "student_room varchar(20)," +
            "student_remark varchar(200))";


    private int id;
    private String userName;
    private String studentName;
    private String studentSex;
    private int studentAge;
    private int studentNumber;
    private String studentClassroom;
    private String studentInstitute;
    private String studentMajor;
    private String studentRoom;
    private String studentRemark;


    public  Student(){
    }

    public Student(int id, String userName, String studentName, String studentSex, int studentAge, int studentNumber, String studentClassroom, String studentInstitute, String studentMajor, String studentRoom, String studentRemark) {
        this.id = id;
        this.userName = userName;
        this.studentName = studentName;
        this.studentSex = studentSex;
        this.studentAge = studentAge;
        this.studentNumber = studentNumber;
        this.studentClassroom = studentClassroom;
        this.studentInstitute = studentInstitute;
        this.studentMajor = studentMajor;
        this.studentRoom = studentRoom;
        this.studentRemark = studentRemark;
    }

    public static String getTblStudent() {
        return TBL_STUDENT;
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

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentClassroom() {
        return studentClassroom;
    }

    public void setStudentClassroom(String studentClassroom) {
        this.studentClassroom = studentClassroom;
    }

    public String getStudentInstitute() {
        return studentInstitute;
    }

    public void setStudentInstitute(String studentInstitute) {
        this.studentInstitute = studentInstitute;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentRoom() {
        return studentRoom;
    }

    public void setStudentRoom(String studentRoom) {
        this.studentRoom = studentRoom;
    }

    public String getStudentRemark() {
        return studentRemark;
    }

    public void setStudentRemark(String studentRemark) {
        this.studentRemark = studentRemark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentAge=" + studentAge +
                ", studentNumber=" + studentNumber +
                ", studentClassroom='" + studentClassroom + '\'' +
                ", studentInstitute='" + studentInstitute + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentRoom='" + studentRoom + '\'' +
                ", studentRemark='" + studentRemark + '\'' +
                '}';
    }
}
