package com.example.homework.service;

import android.content.Context;

import com.example.homework.dao.RoomDao;
import com.example.homework.dao.RoomDaoImpl;
import com.example.homework.dao.StudentDao;
import com.example.homework.dao.StudentDaoImpl;
import com.example.homework.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl(Context context) {
        studentDao = new StudentDaoImpl(context);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }

    @Override
    public Student select(String student){
        return studentDao.select(student);
    }

    @Override
    public void modifyRealNumber(Student student) {
        studentDao.update(student);

    }

    @Override
    public void delete(String studentName) {
        studentDao.delete(studentName);
    }
}
