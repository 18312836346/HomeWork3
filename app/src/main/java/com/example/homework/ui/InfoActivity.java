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
import com.example.homework.model.AdmInfo;
import com.example.homework.service.AdmService;
import com.example.homework.service.AdmServiceImpl;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Tx_name,Tx_number,Tx_phone;
    private AdmService admService;
    private AdmInfo admInfo;
    private AdmCount admCount;
    private String username;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        admService = new AdmServiceImpl(this);

        Button button = findViewById(R.id.btn_break);
        Button button1= findViewById(R.id.btn_revice);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);







        initView();
        initData();
    }

    private void initView() {
        Tx_name = findViewById(R.id.adm_name1);
        Tx_number = findViewById(R.id.adm_number1);
        Tx_phone = findViewById(R.id.adm_phone1);
    }



    private void initData() {
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");

        // 从登陆成功之后传递给你

        if(userName != null) {
            admService = new AdmServiceImpl(this);
            admInfo = admService.selectAdmInfo(userName);
            Tx_name.setText(admInfo.getAdmName());
            Tx_number.setText(String.valueOf(admInfo.getAdmJobNumber()));
            Tx_phone.setText(String.valueOf(admInfo.getAdmPhone()));
        } else {
            Toast.makeText(InfoActivity.this,"没有拿到登陆信息",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.btn_break:
                intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_revice:
                intent = new Intent(InfoActivity.this, AlterInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("info", admInfo);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }


}
