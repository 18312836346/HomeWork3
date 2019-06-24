package com.example.homework.service;

import com.example.homework.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public void insert(Student student);
    public Student select(String studentname);
    public void modifyRealNumber(Student student);
    public void delete(String studentName);
}
