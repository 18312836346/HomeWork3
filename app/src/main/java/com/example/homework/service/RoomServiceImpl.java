package com.example.homework.service;

import android.content.Context;

import com.example.homework.dao.RoomDao;
import com.example.homework.dao.RoomDaoImpl;
import com.example.homework.model.Room;

import java.util.List;


public class RoomServiceImpl implements RoomService{
    private RoomDao roomDao;

    public RoomServiceImpl(Context context) {
        roomDao = new RoomDaoImpl(context);
    }

    public List<Room> getAllRooms() {
        return roomDao.selectAllRooms();
    }

    public void insert(Room room) {
        roomDao.insert(room);
    }

    @Override
    public void modifyRealNumber(Room room) {
        roomDao.update(room);
    }

    @Override
    public void delete(String roomName) {
        roomDao.delete(roomName);
    }
}