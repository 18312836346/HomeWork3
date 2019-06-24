package com.example.homework.service;

import com.example.homework.model.Room;

import java.util.List;

public interface RoomService {
    public List<Room> getAllRooms();
    public void insert(Room room);
    public void modifyRealNumber(Room room);
    public void delete(String roomName);
}
