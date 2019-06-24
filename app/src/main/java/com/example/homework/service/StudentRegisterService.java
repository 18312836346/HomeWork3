package com.example.homework.service;

import com.example.homework.model.Room;
import com.example.homework.model.StudentRegister;

import java.util.List;

public interface StudentRegisterService {
    public List<StudentRegister> getAllRooms();
    public void insert(StudentRegister room);
    public void modifyRealNumber(StudentRegister room);
    public void delete(String roomName);
}
