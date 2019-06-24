package com.example.homework.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.homework.model.AdmCount;
import com.example.homework.model.AdmInfo;
import com.example.homework.model.God;
import com.example.homework.model.Room;
import com.example.homework.model.Sign;
import com.example.homework.model.Sign2;
import com.example.homework.model.Student;
import com.example.homework.model.StudentRegister;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "demo.db", null, 2);
    }
    // 当app发现没有demo.db时会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Room.TBL_ROOM);
        db.execSQL(Student.TBL_STUDENT);
        db.execSQL(Sign.TBL_AD_SIGN);
        db.execSQL(Sign2.TBL_SIGN2);
        db.execSQL(StudentRegister.TBL_ST_REGISTER);
        db.execSQL(God.TBL_GOD);
        db.execSQL(AdmCount.TBL_ADMCOUNT);
        db.execSQL(AdmInfo.TBL_ADMINFO);
    }
    // 当app发现有demo.db时，而且version有变化时会自动调用onUpgrade更新数据库表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists t_room");
        db.execSQL("drop table if exists t_student_info");
        db.execSQL("drop table if exists t_ad_sign");
        db.execSQL("drop table if exists t_st_sign");
        db.execSQL("drop table if exists t_st_register");
        db.execSQL("drop table if exists t_gods");
        db.execSQL("drop table if exists t_admcount");
        db.execSQL("drop table if exists t_adminfo");
        onCreate(db);
    }
}

