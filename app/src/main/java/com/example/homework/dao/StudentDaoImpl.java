package com.example.homework.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.homework.model.Student;
import com.example.homework.util.DBHelper;

import java.util.ArrayList;
import java.util.List;
public class StudentDaoImpl implements StudentDao{

        private DBHelper dbHelper;
        private SQLiteDatabase db;

        public StudentDaoImpl(Context context) {
            dbHelper = new DBHelper(context);
        }



        @Override
        public List<Student> selectAllStudents() {
            String sql = "select * from t_student_info";
            List<Student> students = null;

            // 1. 获取SQLiteDatabase对象
            db = dbHelper.getReadableDatabase();

            // 2. 执行SQL查询
            // Cursor cursor = db.query(Student.TBL_NAME, null, null, null, null, null, null);
            Cursor cursor = db.rawQuery(sql, null);

            // 3. 处理结果
            if (cursor != null && cursor.getCount() > 0) {
                students = new ArrayList<>();
                while (cursor.moveToNext()) {
                    Student student = new Student();

                    student.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    student.setUserName(cursor.getString(cursor.getColumnIndex("username")));
                    student.setStudentName(cursor.getString(cursor.getColumnIndex("student_name")));
                    student.setStudentSex(cursor.getString(cursor.getColumnIndex("student_sex")));
                    student.setStudentAge(cursor.getInt(cursor.getColumnIndex("student_age")));
                    student.setStudentNumber(cursor.getInt(cursor.getColumnIndex("student_number")));
                    student.setStudentClassroom(cursor.getString(cursor.getColumnIndex("student_classroom")));
                    student.setStudentInstitute(cursor.getString(cursor.getColumnIndex("student_institute")));
                    student.setStudentMajor(cursor.getString(cursor.getColumnIndex("student_major")));
                    student.setStudentRoom(cursor.getString(cursor.getColumnIndex("student_room")));
                    student.setStudentRemark(cursor.getString(cursor.getColumnIndex("student_remark")));

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
        public Student select(String studentName) {
            String sql = "select * from t_student_info where student_name=?";
            Student student = null;
            // 1. 获取SQLiteDatabase对象
            db = dbHelper.getReadableDatabase();
            // 2. 执行SQL查询
            Cursor cursor = db.rawQuery(sql, new String[]{studentName});
            // 3. 处理结果
            if (cursor != null && cursor.getCount() > 0) {
                if (cursor.moveToNext()) {
                    student = new Student();

                    student.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    student.setUserName(cursor.getString(cursor.getColumnIndex("username")));
                    student.setStudentName(cursor.getString(cursor.getColumnIndex("student_name")));
                    student.setStudentSex(cursor.getString(cursor.getColumnIndex("student_sex")));
                    student.setStudentAge(cursor.getInt(cursor.getColumnIndex("student_age")));
                    student.setStudentNumber(cursor.getInt(cursor.getColumnIndex("student_number")));
                    student.setStudentClassroom(cursor.getString(cursor.getColumnIndex("student_classroom")));
                    student.setStudentInstitute(cursor.getString(cursor.getColumnIndex("student_institute")));
                    student.setStudentMajor(cursor.getString(cursor.getColumnIndex("student_major")));
                    student.setStudentRoom(cursor.getString(cursor.getColumnIndex("student_room")));
                    student.setStudentRemark(cursor.getString(cursor.getColumnIndex("student_remark")));
                }
                // 4. 关闭cursor
                cursor.close();
            }
            db.close();
            // 5. 返回结果
            return student;
        }


        @Override
        public List<Student> selectByNumber() {


            return null;
        }

        @Override
        public void insert(Student student) {
            db = dbHelper.getWritableDatabase();
            String sql = "insert into t_student_info values(null,?,?,?,?,?,?,?,?,?,?)";
            db.execSQL(sql, new Object[]{
                    student.getStudentName(),
                    student.getUserName(),
                    student.getStudentSex(),
                    student.getStudentAge(),
                    student.getStudentNumber(),
                    student.getStudentClassroom(),
                    student.getStudentInstitute(),
                    student.getStudentMajor(),
                    student.getStudentRoom(),
                    student.getStudentRemark()});

            db.close();
        }

        //修改
        @Override
        public void update(Student student) {
            // 1. 获取db对象
            db = dbHelper.getWritableDatabase();
            // 2. 执行sql
            String sql = "update t_student_info set student_number=? where student_name=?";
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
            String sql = "delete from t_student_info where student_name=?";
            db.execSQL(sql, new Object[]{ studentName });

        }

    }
