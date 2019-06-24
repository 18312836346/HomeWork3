package com.example.homework.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;
import com.example.homework.model.AdmCount;
import com.example.homework.model.Sign;
import com.example.homework.service.AdmService;
import com.example.homework.service.AdmServiceImpl;
import com.example.homework.service.SignService;

public class SafCountActivyty extends AppCompatActivity implements View.OnClickListener{

    private TextView userName,passWord;
    private String username;
    private AdmService admService;
    private AdmCount admCount;
    private SignService signService;
    private Sign sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saf_count);

        Button button = findViewById(R.id.btn_revice);
        Button button1 = findViewById(R.id.btn_break);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        initView();
        initData();
    }



    private void initData() {
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        String admName = username;
        // 从登陆成功之后传递给你



        if(admName != null) {
            signService = new SignService(this);
            admService = new AdmServiceImpl(this);
            admCount = admService.selectAdmCout(admName);


            userName.setText(admCount.getUserName());
            passWord.setText(String.valueOf(admCount.getPassWord()));
        } else {
            Toast.makeText(SafCountActivyty.this,"没有拿到登陆信息",Toast.LENGTH_LONG).show();
        }
    }

    private void initView() {
        userName = findViewById(R.id.Sadm_username);
        passWord = findViewById(R.id.Sadm_password);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.btn_revice:
                intent = new Intent(SafCountActivyty.this, AlterCountActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("count", admCount);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.btn_break:
                intent = new Intent(SafCountActivyty.this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }

}

