package com.example.homework.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homework.model.AdmCount;
import com.example.homework.model.AdmInfo;
import com.example.homework.util.DBHelper;
public class AdmDaoImpl implements AdmDao {
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    public AdmDaoImpl(Context context) {
        // 调用MyDBHelper类的构造方法时，
        // 若发现demo.db不存在会调用onCreate方法创建
        // 若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        dbHelper = new DBHelper(context);
    }

    @Override
    public AdmInfo selectAdmInfo(String userName) {
        String sql = "select * from t_adminfo where username=?";
        AdmInfo admInfo = null;

        db=dbHelper.getReadableDatabase();

        Cursor cursor =db.rawQuery(sql,new String[]{userName});

        if (cursor !=null && cursor.getCount()>0){
            if (cursor.moveToNext()){
                admInfo = new AdmInfo();
                admInfo.setId(cursor.getInt(cursor.getColumnIndex("id")));
                admInfo.setUserName(cursor.getString(cursor.getColumnIndex("username")));
                admInfo.setAdmName(cursor.getString(cursor.getColumnIndex("name")));
                admInfo.setAdmJobNumber(cursor.getInt(cursor.getColumnIndex("job_number")));
                admInfo.setAdmPhone(cursor.getInt(cursor.getColumnIndex("phone")));
            }
            cursor.close();
        }

        return admInfo;
    }

    @Override
    public AdmCount selectAdmCount(String userName) {
        String sql = "select * from t_admcount where username=?";
        AdmCount admCount = null;
        db=dbHelper.getReadableDatabase();

        Cursor cursor =db.rawQuery(sql,new String[]{userName});

        if (cursor !=null && cursor.getCount()>0){
            if (cursor.moveToNext()){
                admCount = new AdmCount();
                admCount.setId(cursor.getInt(cursor.getColumnIndex("id")));
                admCount.setUserName(cursor.getString(cursor.getColumnIndex("username")));
                admCount.setPassWord(cursor.getString(cursor.getColumnIndex("password")));
            }
            cursor.close();
        }

        return admCount;
    }

    @Override
    public void update(AdmCount admCount) {
        db = dbHelper.getWritableDatabase();
        String sql = "update t_admcount set password = ?  where username=?";
        db.execSQL(sql,new Object[]{
                admCount.getPassWord(),
                admCount.getUserName()
        });
    }

    @Override
    public void update(AdmInfo admInfo) {
        db = dbHelper.getWritableDatabase();
        String sql = "update t_adminfo set job_number=?,phone=?, name=? where username=?";
        db.execSQL(sql,new Object[]{
                admInfo.getAdmJobNumber(),
                admInfo.getAdmPhone(),
                admInfo.getAdmName(),
                admInfo.getUserName()
        });
    }

    @Override
    public void insert(AdmCount admCount) {
        db = dbHelper.getWritableDatabase();
        String sql = "insert into t_admcount values(null,?,?)";
        db.execSQL(sql,new Object[]{
                admCount.getUserName(),
                admCount.getPassWord(),});
        db.close();

    }

    @Override
    public void insert(AdmInfo admInfo) {
        db = dbHelper.getWritableDatabase();
        String sql = "insert into t_adminfo values(null,?,?,?,?)";
        db.execSQL(sql,new Object[]{
                admInfo.getAdmName(),
                admInfo.getAdmJobNumber(),
                admInfo.getAdmPhone(),
                admInfo.getUserName(),
        });
        db.close();

    }

    @Override
    public void delete(AdmCount admCount) {
        db=dbHelper.getWritableDatabase();
        String sql = "delete from t_admcount where username=?";
        db.execSQL(sql, new Object[]{
                admCount});
    }

    @Override
    public void delete(AdmInfo admInfo) {
        db = dbHelper.getWritableDatabase();
        String sql = "delete from t_adminfo where username=?";
        db.execSQL(sql,new Object[]{
                admInfo});
    }
}