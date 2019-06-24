package com.example.homework.dao;




import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.homework.model.God;
import com.example.homework.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class GodDaoImpl implements GodDao {

    private DBHelper helper;
    private SQLiteDatabase db;


    public GodDaoImpl(Context context){
        //调用DBHelper类的构造方法时
        // 如发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper= new DBHelper( context);
    }
    @Override
    public void insert(God god) {
        //1、获取db对象
        db= helper.getWritableDatabase();
        String sql="insert into t_gods values(null,?,?,?,?,?,?)";
        //执行sql
        db.execSQL( sql,new Object[]{
                god.getGodsNumber(),
                god.getGodsName(),
                god.getPersonName(),
                god.getPersonPhone(),
                god.getGodsGoOutTime(),
                god.getGodsReturnTime()

        } );
        db.close();

    }


    @Override
    public void delete(String godsNumber) {

        //1、获取db对象
        db= helper.getWritableDatabase();
        // 2. 执行sql
        String sql="delete from t_gods where gods_number =?";
        db.execSQL( sql,new Object[]{godsNumber});

    }

    @Override
    public void update(God god) {
        //1、获取db对象
        db= helper.getWritableDatabase();
        // 2. 执行sql
        String sql="update t_gods  set person_name= ? where gods_number =?";
        db.execSQL( sql,new Object[]{
                god.getPersonName(),
                god.getGodsNumber()
        } );


    }

    @Override
    public List<God> selectAllGods() {
        String sql = "select * from t_gods";
        List<God> gods = null;

        //1、获取SQLiteDateBase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery( sql,null );//跟Result类似
        //3、处理结果
        if (cursor!=null&&cursor.getCount()>0){

            gods = new ArrayList<>(  );
            while (cursor.moveToNext()){
                God god = new God( );
                god.setId( cursor.getInt( cursor.getColumnIndex( "id" ) ) );
                god.setGodsNumber( cursor.getString( cursor.getColumnIndex( "gods_number" ) ) );
                god.setGodsName( cursor.getString( cursor.getColumnIndex( "gods_name" ) ) );
                god.setPersonName( cursor.getString( cursor.getColumnIndex( "person_name" ) ) );
                god.setPersonPhone( cursor.getInt( cursor.getColumnIndex( "person_phone" ) ) );
                god.setGodsGoOutTime( cursor.getString( cursor.getColumnIndex( "gods_go_out_time" ) ) );
                god.setGodsReturnTime( cursor.getString( cursor.getColumnIndex( "gods_return_time" ) ) );
                gods.add( god );
            }

            //关闭cursor
            cursor.close();
        }

        db.close();
        //4、返回
        return gods;


    }

    @Override
    public God select(String godsNumber) {


        String sql = "select * from t_gods where gods_number=?";
        God god = null;

        // 1. 获取SQLiteDatabase对象
        db = helper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{godsNumber});

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                god = new God();
                god.setId( cursor.getInt( cursor.getColumnIndex( "id" ) ) );
                god.setGodsNumber( cursor.getString( cursor.getColumnIndex( "gods_number" ) ) );
                god.setGodsName( cursor.getString( cursor.getColumnIndex( "gods_name" ) ) );
                god.setPersonName( cursor.getString( cursor.getColumnIndex( "person_name" ) ) );
                god.setPersonPhone( cursor.getInt( cursor.getColumnIndex( "person_phone" ) ) );
                god.setGodsGoOutTime( cursor.getString( cursor.getColumnIndex( "gods_go_out_time" ) ) );
                god.setGodsReturnTime( cursor.getString( cursor.getColumnIndex( "gods_return_time" ) ) );

            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return god;

    }
}

