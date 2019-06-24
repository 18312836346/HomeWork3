package com.example.homework.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homework.model.Student;
import com.example.homework.model.StudentRegister;
import com.example.homework.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentRegisterDaoImpl implements StudentRegisterDao {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public StudentRegisterDaoImpl(Context context) {
        // 调用MyDBHelper类的构造方法时，
        // 若发现demo.db不存在会调用onCreate方法创建
        // 若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        dbHelper = new DBHelper(context);
    }
    @Override
    public List<StudentRegister> selectAllmessage() {
        String sql = "select * from t_st_register";
        List<StudentRegister> students = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        // Cursor cursor = db.query(Student.TBL_NAME, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            students = new ArrayList<>();
            while (cursor.moveToNext()) {
                StudentRegister student = new StudentRegister();

                student.setId(cursor.getInt(cursor.getColumnIndex("id")));
                student.setStudentName(cursor.getString(cursor.getColumnIndex("student_name")));
                student.setStudentSex(cursor.getString(cursor.getColumnIndex("student_sex")));
                student.setStudentNumber(cursor.getInt(cursor.getColumnIndex("student_number")));
                student.setStudentPhone(cursor.getInt(cursor.getColumnIndex("student_phone")));
                student.setStudentXueyuan(cursor.getString(cursor.getColumnIndex("student_xueyuan")));
                student.setDestination(cursor.getString(cursor.getColumnIndex("destination")));
                student.setStudentClass(cursor.getString(cursor.getColumnIndex("student_class")));
                student.setStudentRoom(cursor.getString(cursor.getColumnIndex("student_room")));
                student.setIntotime(cursor.getString(cursor.getColumnIndex("intotime")));
                student.setOuttime(cursor.getString(cursor.getColumnIndex("outtime")));
                students.add(student);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return students;
    }

    @Override
    public StudentRegister select(String studentName) {
        String sql = "select * from t_st_register where student_name=?";
        StudentRegister student = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{studentName});

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                student = new StudentRegister();

                student.setId(cursor.getInt(cursor.getColumnIndex("id")));
                student.setStudentName(cursor.getString(cursor.getColumnIndex("student_name")));
                student.setStudentSex(cursor.getString(cursor.getColumnIndex("student_sex")));
                student.setStudentNumber(cursor.getInt(cursor.getColumnIndex("student_number")));
                student.setStudentPhone(cursor.getInt(cursor.getColumnIndex("student_phone")));
                student.setStudentXueyuan(cursor.getString(cursor.getColumnIndex("student_xueyuan")));
                student.setDestination(cursor.getString(cursor.getColumnIndex("destination")));
                student.setStudentClass(cursor.getString(cursor.getColumnIndex("student_class")));
                student.setStudentRoom(cursor.getString(cursor.getColumnIndex("student_room")));
                student.setIntotime(cursor.getString(cursor.getColumnIndex("intotime")));
                student.setOuttime(cursor.getString(cursor.getColumnIndex("outtime")));
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return student;
    }


    @Override
    public List<StudentRegister> selectByNumber() {

        return null;
    }

    @Override
    public void insert(StudentRegister student) {
        db = dbHelper.getWritableDatabase();
        String sql = "insert into t_st_register values(null,?,?,?,?,?,?,?,?,?,?)";
        db.execSQL(sql, new Object[]{
                student.getStudentName(),
                student.getStudentSex(),
                student.getStudentNumber(),
                student.getStudentPhone(),
                student.getStudentXueyuan(),
                student.getDestination(),
                student.getStudentClass(),
                student.getStudentRoom(),
                student.getIntotime(),
                student.getOuttime()});
        db.close();
    }

    //修改
    @Override
    public void update(StudentRegister student) {
        // 1. 获取db对象
        db = dbHelper.getWritableDatabase();
        // 2. 执行sql
        String sql = "update t_st_register set student_number=? where student_name=?";
        db.execSQL(sql, new Object[]{
                student.getStudentNumber(),
                student.getStudentName()
        });
    }

    @Override
    public void delete(String studentName) {
        // 1. 获取db对象
        db = dbHelper.getWritableDatabase();
        // 2. 执行sql
        String sql = "delete from t_st_register where student_name=?";
        db.execSQL(sql, new Object[]{ studentName });

    }
}
