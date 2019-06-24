package com.example.homework.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.homework.R;
import com.example.homework.model.Student;
import com.example.homework.service.StudentService;
import com.example.homework.service.StudentServiceImpl;

public class StudentInfoActivity extends AppCompatActivity {

    private StudentService studentService;
    private Student selectedStudent;

    private TextView Su,Su1,Su2,Su3,Su4,Su5,Su6,Su7,Su8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);


        Su= findViewById(R.id.su);
        Su1= findViewById(R.id.su1);
        Su2= findViewById(R.id.su2);
        Su3= findViewById(R.id.su3);
        Su4= findViewById(R.id.su4);
        Su5= findViewById(R.id.su5);
        Su6= findViewById(R.id.su6);
        Su7= findViewById(R.id.su7);
        Su8= findViewById(R.id.su8);

        initData();
    }

    private void initData() {


        Intent intent = getIntent();
        String name = intent.getStringExtra("用户名");

        studentService = new StudentServiceImpl(this);
        selectedStudent = studentService.select(name);
        if(selectedStudent != null) {
            Su.setText(selectedStudent.getStudentName());
            Su1.setText(String.valueOf(selectedStudent.getStudentNumber()));
            Su2.setText(selectedStudent.getStudentSex());
            Su3.setText(String.valueOf(selectedStudent.getStudentAge()));
            Su4.setText(selectedStudent.getStudentClassroom());
            Su5.setText(selectedStudent.getStudentInstitute());
            Su6.setText(selectedStudent.getStudentMajor());
            Su7.setText(selectedStudent.getStudentRoom());
            Su8.setText(selectedStudent.getStudentRemark());
        }
    }
}
