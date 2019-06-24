package com.example.homework.service;


import android.content.Context;

import com.example.homework.dao.AdmDao;
import com.example.homework.dao.AdmDaoImpl;
import com.example.homework.model.AdmCount;
import com.example.homework.model.AdmInfo;
public class AdmServiceImpl implements AdmService {
    private AdmDao admDao;

    public AdmServiceImpl(Context context) {
        admDao = new AdmDaoImpl(context);
    }

    @Override
    public void insert(AdmCount admCount) {
        admDao.insert(admCount);
    }

    @Override
    public void insert(AdmInfo admInfo) {
        admDao.insert(admInfo);

    }

    @Override
    public void delete(AdmCount admCount) {
        admDao.delete(admCount);

    }

    @Override
    public void delete(AdmInfo admInfo) {
        admDao.delete(admInfo);

    }

    @Override
    public void modify(AdmCount admCount) {
        admDao.update(admCount);
    }

    @Override
    public void modify(AdmInfo admInfo) {
        admDao.update(admInfo);

    }

    @Override
    public AdmCount selectAdmCout(String userName) {
        return admDao.selectAdmCount(userName);
    }


    @Override
    public AdmInfo selectAdmInfo(String name) {
        return admDao.selectAdmInfo(name);
    }


}
