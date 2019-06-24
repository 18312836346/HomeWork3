package com.example.homework.dao;

import com.example.homework.model.StudentRegister;

import java.util.List;

public interface StudentRegisterDao {

    List<StudentRegister> selectAllmessage();

    StudentRegister select(String studentName);

    List<StudentRegister> selectByNumber();

    void insert(StudentRegister studentRegister);
    void update(StudentRegister studentRegister);
    void delete(String studentName);
}
