package com.example.homework.service;

import android.content.Context;

import com.example.homework.dao.GodDao;
import com.example.homework.dao.GodDaoImpl;
import com.example.homework.model.God;

import java.util.List;

public class GodServiceImpl implements GodService {

    private GodDao godDao;

    public GodServiceImpl(Context context){
        godDao = new GodDaoImpl( context );
    }

    @Override
    public List<God> getAllGods() {
        return godDao.selectAllGods();
    }

    @Override
    public void insert(God god) {
        godDao.insert( god );

    }

    @Override
    public void modifyPersonName(God god) {
        godDao.update( god );

    }

    @Override
    public void delete(String godsNumber) {
        godDao.delete( godsNumber );


    }
}