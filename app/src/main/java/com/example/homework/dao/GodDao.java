package com.example.homework.dao;


import com.example.homework.model.God;

import java.util.List;

public interface GodDao {

    //增删改物品出入记录
    void insert(God god);
    void delete(String  godsNumber);
    void update(God god);

    //查询所有物品出入记录
    List<God> selectAllGods();

    //根据物品编号查询物品出入记录
    God select(String godsNumber);
}