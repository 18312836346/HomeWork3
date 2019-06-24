package com.example.homework.service;

import android.content.Context;

import com.example.homework.dao.RoomDao;
import com.example.homework.dao.RoomDaoImpl;
import com.example.homework.dao.StudentRegisterDao;
import com.example.homework.dao.StudentRegisterDaoImpl;
import com.example.homework.model.Room;
import com.example.homework.model.StudentRegister;

import java.util.List;

public class StudentRegisterServiceImpl implements StudentRegisterService {

    private StudentRegisterDao studentRegisterDao;

    public StudentRegisterServiceImpl(Context context) {
        studentRegisterDao = new StudentRegisterDaoImpl(context);
    }

    public List<StudentRegister> getAllRooms() {
        return studentRegisterDao.selectAllmessage();
    }

    public void insert(StudentRegister studentRegister) {
        studentRegisterDao.insert(studentRegister);
    }

    @Override
    public void modifyRealNumber(StudentRegister studentRegister) {
        studentRegisterDao.update(studentRegister);
    }

    @Override
    public void delete(String studentName) {
        studentRegisterDao.delete(studentName);
    }
}
