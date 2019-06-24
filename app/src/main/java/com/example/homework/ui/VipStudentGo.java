package com.example.homework.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.homework.R;
import com.example.homework.model.Student;
import com.example.homework.model.StudentRegister;
import com.example.homework.service.StudentRegisterService;
import com.example.homework.service.StudentRegisterServiceImpl;
import com.example.homework.service.StudentService;
import com.example.homework.service.StudentServiceImpl;

import java.util.Arrays;

public class VipStudentGo extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup registerSex;
    private EditText registerName,registerPhone,registerNumber
            ,registerXueyuan,registerClass,registerRoom,destination,goTime,backTime;
    private Button btnRegsave,btnRegreturn;

    private StudentRegister studentRegister;
    private StudentRegisterService studentRegisterService;
    private String flag1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_student_go);
        studentRegisterService = new StudentRegisterServiceImpl(this);

        initView();
        initData();
    }

    private void initView() {
        registerSex = findViewById(R.id.register_sex);
        registerName = findViewById(R.id.register_name);
        registerNumber = findViewById(R.id.register_number);
        registerPhone = findViewById(R.id.register_phone);
        registerXueyuan = findViewById(R.id.register_xueyuan);
        registerClass = findViewById(R.id.register_class);
        registerRoom = findViewById(R.id.register_room);
        goTime = findViewById(R.id.go_time);
        destination = findViewById(R.id.destination);
        backTime = findViewById(R.id.back_time);


        btnRegsave = findViewById(R.id.btn_reg_save);
        btnRegreturn = findViewById(R.id.btn_reg_return);
        btnRegsave.setOnClickListener(this);
        btnRegreturn.setOnClickListener(this);

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


    private void initData() {
        Intent intent = getIntent();
        flag1 = intent.getStringExtra("flag1");

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            studentRegister = (StudentRegister) bundle.getSerializable("register");
            if (studentRegister != null) {
                registerName.setText(studentRegister.getStudentName());
                registerName.setEnabled(false);
                registerNumber.setText(String.valueOf(studentRegister.getStudentNumber()));
                registerRoom.setText(studentRegister.getStudentRoom());
                registerClass.setText(studentRegister.getStudentClass());
                registerXueyuan.setText(studentRegister.getStudentXueyuan());
                registerPhone.setText(String.valueOf(studentRegister.getStudentPhone()));
                destination.setText(studentRegister.getStudentRoom());
                goTime.setText(studentRegister.getOuttime());
                backTime.setText(studentRegister.getIntotime());
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reg_save:
                updateStudent();

                break;
            case R.id.btn_reg_return:
                finish();
        }
    }

    private void updateStudent() {
        if (studentRegister == null) {
            studentRegister = new StudentRegister();
        }
        studentRegister.setStudentName(registerName.getText().toString());
        studentRegister.setStudentSex(getRadioButtonValue( registerSex ));
        studentRegister.setStudentNumber(Integer.valueOf(registerNumber.getText().toString()));
        studentRegister.setStudentPhone(Integer.valueOf(registerPhone.getText().toString()));
        studentRegister.setDestination(destination.getText().toString());
        studentRegister.setStudentRoom(registerRoom.getText().toString());
        studentRegister.setStudentClass(registerClass.getText().toString());
        studentRegister.setStudentXueyuan(registerXueyuan.getText().toString());
        studentRegister.setOuttime(goTime.getText().toString());
        studentRegister.setIntotime(backTime.getText().toString());

        if ("修改".equals(flag1)) {
            studentRegisterService.modifyRealNumber(studentRegister);
        } else if ("添加".equals(flag1)) {
            studentRegisterService.insert(studentRegister);
        }

        // 将修改的数据返回MainActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("register", studentRegister);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}