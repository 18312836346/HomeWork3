package com.example.homework.service;


import com.example.homework.model.God;

import java.util.List;

public interface GodService {

    public List<God> getAllGods();
    public void insert(God god);
    public void modifyPersonName(God god);
    public void delete(String godsNumber);

}