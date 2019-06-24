package com.example.homework.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;
import com.example.homework.model.Sign2;
import com.example.homework.service.Sign2Service;
import com.example.homework.service.SignService;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText upPassword,upPassword2,upUsername;
    private Button update,upReturn;
    private TextView texxx;
    private Sign2Service sign2Service;
    private Sign2 sign2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        sign2Service = new Sign2Service(this);
        texxx=findViewById(R.id.texxx);
        upUsername= findViewById(R.id.up_username);
        upPassword= findViewById(R.id.up_password);
        upPassword2= findViewById(R.id.up_password2);
        update= findViewById(R.id.update);
        upReturn=findViewById(R.id.up_return);
        update.setOnClickListener(this);
        upReturn.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.update:
                updataPassword();
                break;
            case R.id.up_return:
                Intent intent1 = new Intent(UpdateActivity.this,StudentAdministration2Fragment.class);
                startActivity(intent1);
                break;
        }
    }

    private void updataPassword() {

        Intent intent = getIntent();
        String name = intent.getStringExtra("用户名");


        Sign2 sign = new Sign2();
        sign.setUsername(name);
        sign.setPassword(upUsername.getText().toString());
        // 2. 判断
        boolean result = sign2Service.login(sign);


        if (sign2 == null) {
            sign2 = new Sign2();
        }
        sign2.setUsername(name);
        sign2.setPassword(upPassword.getText().toString());

        if (result&&sign2 != null) {
            sign2Service.modifyPassword(sign2);
            Toast.makeText(UpdateActivity.this,"修改成功",Toast.LENGTH_LONG).show();
        }
    }
}
