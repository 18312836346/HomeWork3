package com.example.homework.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;
import com.example.homework.model.Sign;
import com.example.homework.model.Sign2;
import com.example.homework.model.Student;
import com.example.homework.service.Sign2Service;
import com.example.homework.service.SignService;
import com.example.homework.service.StudentService;
import com.example.homework.service.StudentServiceImpl;

public class StudentSignInActivity extends AppCompatActivity implements View.OnClickListener {


    private RadioGroup studentSex;
    private EditText studentName,studentAge,studentNumber,studentClass,
            studentInstitute,studentMajor,studentRoom;
    private EditText stUsername, stPassword, stPassword2;
    private Button stSignin, stReturn;
    private TextView tvStSuccess;

    private Sign2Service service;
    private StudentService studentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_in);

        studentName=findViewById(R.id.studentname);
        studentAge=findViewById(R.id.studentage);
        studentNumber=findViewById(R.id.studentnumber);
        studentClass=findViewById(R.id.studentclass);
        studentInstitute=findViewById(R.id.studentinstitute);
        studentMajor= findViewById(R.id.studentmajor);
        studentRoom=findViewById(R.id.studentroom);
        studentSex=findViewById(R.id.studentsex);

        tvStSuccess = findViewById(R.id.tv_st_success);
        stUsername = findViewById(R.id.st_username);
        stPassword = findViewById(R.id.st_password);
        stPassword2 = findViewById(R.id.st_password2);
        stReturn = findViewById(R.id.st_return);
        stSignin = findViewById(R.id.st_signin);
        stSignin.setOnClickListener(this);
        stReturn.setOnClickListener(this);


        service = new Sign2Service(this);
        studentService = new StudentServiceImpl(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.st_signin:
                register();
                break;
            case R.id.st_return:
                Intent intent = new Intent(StudentSignInActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }


    private String getRadioButtonValue(RadioGroup rg) {
        String result = null;
        int id = rg.getCheckedRadioButtonId();
        if(id == R.id.btn_male) {
            result = "男";
        } else if (id == R.id.btn_female) {
            result = "女";
        }
        return result;
    }

    private void register() {
        // 1. 比较两次输入的密码是否一致
        String pwd = stUsername.getText().toString();
        String pwd1 = stPassword2.getText().toString();
        String user = stUsername.getText().toString();


        if (!pwd.equals("") && pwd.equals(pwd1) && !user.equals("")) {
            // 2. 获取输入的信息
            Sign2 sign = new Sign2();
            Student student = new Student();

            sign.setUsername(stUsername.getText().toString());
            sign.setPassword(stPassword.getText().toString());

            student.setUserName(stUsername.getText().toString());
            student.setStudentName(studentName.getText().toString());
            student.setStudentNumber(Integer.parseInt(studentNumber.getText().toString()));
            student.setStudentAge(Integer.parseInt(studentAge.getText().toString()));
            student.setStudentInstitute(studentInstitute.getText().toString());
            student.setStudentMajor(studentMajor.getText().toString());
            student.setStudentRoom(studentRoom.getText().toString());
            student.setStudentClassroom(studentClass.getText().toString());
            student.setStudentSex(getRadioButtonValue( studentSex ));


            // 3. 去数据库注册

            boolean result = service.register(sign);
            // 4. 注册成功跳转到登录界面
            if (result) {
                studentService.insert(student);
                Intent intent = new Intent(StudentSignInActivity.this, LoginActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(StudentSignInActivity.this, "注册失败", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(StudentSignInActivity.this, "两次密码不一致或内容为空", Toast.LENGTH_LONG).show();
        }
    }
}
