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
import com.example.homework.service.AdmService;
import com.example.homework.service.AdmServiceImpl;

public class AlterCountActivity extends AppCompatActivity  implements View.OnClickListener{
    private AdmCount admCount;
    private EditText et_pass,et_newpass;
    private AdmService admService;
    private TextView tx_username,tx_password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_count);

        et_pass = findViewById(R.id.adm_newpassword);
        et_newpass=findViewById(R.id.adm_comfirmpassword);
        tx_username= findViewById(R.id.adm_username);
        tx_password= findViewById(R.id.adm_password);

        Button button = findViewById(R.id.btn_alt);
        admService = new AdmServiceImpl(this);
        button.setOnClickListener(this);

        initdata();


    }



    private void initdata() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            admCount = (AdmCount) bundle.getSerializable("count");
            if (admCount != null) {
                tx_username.setText(admCount.getUserName());
                tx_password.setText(String.valueOf(admCount.getPassWord()));
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_alt:
                updateCount();

                break;
        }
    }

    private void updateCount() {
        if (admCount == null) {
            admCount = new AdmCount();
        }
        admCount.setUserName(et_pass.getText().toString());
        admCount.setPassWord(et_newpass.getText().toString());
        if (et_pass!=null){
            admService.modify(admCount);
            Intent intent = new Intent(AlterCountActivity.this, SafCountActivyty.class);
            Toast.makeText(AlterCountActivity.this,"密码修改成功",Toast.LENGTH_LONG).show();
            startActivity(intent);
        }else {
            Toast.makeText(AlterCountActivity.this,"两次输入不一致",Toast.LENGTH_LONG).show();
        }
    }


}