package com.example.homework.dao;


import com.example.homework.model.Sign;
import com.example.homework.model.Sign2;

import java.util.List;

public interface Sign2Dao {

    List<Sign2> selectAllUsernames();

    //条件查询
//    Room select(String roomName);
//    List<Room> selectByCost(int cost);
    void upPassword(Sign2 sign2);

    Sign2 select(String userName);
    //添删改一个宿舍
    void insert(Sign2 sign2);
    void update(Sign2 sign2);
    void delete(String sign2);
}
