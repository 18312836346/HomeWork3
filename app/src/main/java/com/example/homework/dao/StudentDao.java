package com.example.homework.dao;

import com.example.homework.model.Student;

import java.util.List;

public interface StudentDao {
    // 查询所有的学生信息
    List<Student> selectAllStudents();

    // 根据姓名名查询
    Student select(String studentName);

    // 查询所有未住满的宿舍
    List<Student> selectByNumber();

    // 增删改一个学生
    void insert(Student student);
    void update(Student student);
    void delete(String studentName);
}

