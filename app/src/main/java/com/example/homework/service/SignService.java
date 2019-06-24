package com.example.homework.service;


import android.content.Context;

import com.example.homework.dao.RoomDao;
import com.example.homework.dao.RoomDaoImpl;
import com.example.homework.dao.SignDao;
import com.example.homework.dao.SignDaoImpl;
import com.example.homework.model.Sign;
import com.example.homework.ui.AdministrationLoginFragment;

import java.util.List;

public class SignService {
    private SignDao signDao;

    public SignService(Context context) {
        signDao = new SignDaoImpl(context);
    }



    //1.完成登录功能
    public boolean login(Sign sign) {
        Sign s = signDao.select(sign.getUsername());
        if(s != null && s.getPassword().equals(sign.getPassword())) {
            return true;
        }
        return  false;
    }
//2.完成注册功能
    public boolean register(Sign sign) {
        Sign s=signDao.select(sign.getUsername());
        if (s==null){
            signDao.insert(sign);
            return true;
        }
        return false;
    }

}
