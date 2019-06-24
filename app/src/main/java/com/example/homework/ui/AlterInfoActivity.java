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
import com.example.homework.model.AdmInfo;
import com.example.homework.service.AdmService;
import com.example.homework.service.AdmServiceImpl;

public class AlterInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView admNmae,admNumber,admPhone;
    private EditText newAdmName,newAdmNumber,newAdmPhone;
    private AdmInfo admInfo;
    private AdmService admService;
    private String Jobnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_info);
        admService = new AdmServiceImpl(this);

        Button button = findViewById(R.id.btn_altinfo);
        button.setOnClickListener(this);

        initView();
        initDate();
    }

    private void initView() {

        admNmae = findViewById(R.id.adm_name);
        admNumber = findViewById(R.id.adm_number);
        admPhone = findViewById(R.id.adm_phone);
        newAdmName = findViewById(R.id.adm_newname);
        newAdmNumber = findViewById(R.id.adm_new_number);
        newAdmPhone = findViewById(R.id.adm_new_phone);
    }

    private void initDate() {

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.btn_altinfo:
                updateInfo();
                break;
        }
    }

    private void updateInfo() {

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        if(bundle != null) {
//            admInfo = (AdmInfo) bundle.getSerializable("info");
//            if (admInfo != null) {
//                admNmae.setText(admInfo.getAdmName());
//                admNumber.setText(String.valueOf(admInfo.getAdmJobNumber()));
//                admPhone.setText(String.valueOf(admInfo.getAdmPhone()));
//            }
//        }


        admInfo = new AdmInfo();

        admInfo.setAdmName(newAdmName.getText().toString());
        admInfo.setAdmJobNumber(Integer.valueOf(newAdmNumber.getText().toString()));
        admInfo.setAdmPhone(Integer.valueOf(newAdmPhone.getText().toString()));
        if (admInfo != null) {
            admService.modify(admInfo);

            Intent intent1 = new Intent(AlterInfoActivity.this, MainActivity.class);
            Toast.makeText(AlterInfoActivity.this, "个人信息修改成功", Toast.LENGTH_LONG).show();
            startActivity(intent1);
        }
    }
}
