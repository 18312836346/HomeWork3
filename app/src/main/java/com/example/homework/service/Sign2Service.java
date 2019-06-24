package com.example.homework.service;

import android.content.Context;

import com.example.homework.dao.Sign2Dao;
import com.example.homework.dao.Sign2DaoImpl;
import com.example.homework.model.Sign2;

public class Sign2Service {
    private Sign2Dao signDao;
    public Sign2Service(Context context) { signDao = new Sign2DaoImpl(context); }

    //1.完成登录功能
    public boolean login(Sign2 sign) {
        Sign2 s = signDao.select(sign.getUsername());
        if(s != null && s.getPassword().equals(sign.getPassword())) {
            return true;
        }
        return  false;
    }



    //2.完成注册功能
    public boolean register(Sign2 sign) {
        Sign2 s=signDao.select(sign.getUsername());
        if (s==null){
            signDao.insert(sign);
            return true;
        }
        return false;
    }

    public void modifyPassword(Sign2 sign2) {
        signDao.update(sign2);
    }

}
