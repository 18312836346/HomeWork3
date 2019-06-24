package com.example.homework.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;
import com.example.homework.model.AdmCount;
import com.example.homework.model.AdmInfo;
import com.example.homework.model.Sign;
import com.example.homework.model.Sign2;
import com.example.homework.service.AdmService;
import com.example.homework.service.AdmServiceImpl;
import com.example.homework.service.Sign2Service;
import com.example.homework.service.SignService;
import com.example.homework.service.StudentService;

public class VipSignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText adUsername,adPassword,adPassword2,et_name,et_number,et_phone;
    private Button adSignin,adReturn;
    private TextView tvAdSuccess;

    private SignService service;
    private AdmService admService;
    private AdmInfo admInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_sign_in);

        et_name = findViewById(R.id.et_name);
        et_number = findViewById(R.id.et_admnumber);
        et_phone = findViewById(R.id.et_phone);
        tvAdSuccess = findViewById(R.id.tv_ad_success);
        adUsername= findViewById(R.id.ad_username);
        adPassword= findViewById(R.id.ad_password);
        adPassword2= findViewById(R.id.ad_password2);
        adReturn= findViewById(R.id.ad_return);
        adSignin= findViewById(R.id.ad_signin);
        adSignin.setOnClickListener(this);
        adReturn.setOnClickListener(this);

        admService = new AdmServiceImpl(this);
        service = new SignService(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ad_signin:
                register();
                break;
            case R.id.ad_return:
                Intent intent = new Intent(VipSignInActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void register() {
        // 1. 比较两次输入的密码是否一致
        String pwd = adUsername.getText().toString();
        String pwd1 = adPassword2.getText().toString();
        String user= adUsername.getText().toString();
        if(!pwd.equals("")&&pwd.equals(pwd1)&&!user.equals("")) {
            // 2. 获取输入的信息
            Sign sign = new Sign();
            AdmInfo admInfo = new AdmInfo();

            admInfo.setUserName(adUsername.getText().toString());
            admInfo.setAdmName(et_name.getText().toString());
            admInfo.setAdmJobNumber(Integer.parseInt(et_number.getText().toString()));
            admInfo.setAdmPhone(Integer.parseInt(et_phone.getText().toString()));


            sign.setUsername(adUsername.getText().toString());
            sign.setPassword(adPassword.getText().toString());

            // 3. 去数据库注册
            boolean result = service.register(sign);

            // 4. 注册成功跳转到登录界面
            if (result) {
                admService.insert(admInfo);
                Intent intent = new Intent(VipSignInActivity.this, LoginActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(VipSignInActivity.this, "注册失败", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(VipSignInActivity.this, "两次密码不一致或内容为空", Toast.LENGTH_LONG).show();
        }
    }
}
