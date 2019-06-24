package com.example.homework.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.homework.R;
import com.example.homework.model.God;
import com.example.homework.service.GodService;
import com.example.homework.service.GodServiceImpl;

public class GodActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_gods_number,et_gods_name,et_person_name,et_person_phone;
    private EditText et_go_out_time,et_return_time;
    private Button btnSave, btnCancel;

    private God god;
    private GodService godService;
    private String flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god);
        godService = new GodServiceImpl(this);

        initView();
        initData();


    }

    private void initData() {

        Intent intent = getIntent();
        flag = intent.getStringExtra( "flag" );

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            god = (God) bundle.getSerializable( "god" );
            if (god != null){
                et_gods_number.setText( god.getGodsNumber() );
                et_gods_number.setEnabled( false );
                et_gods_name.setText( god.getGodsName() );
                et_person_name.setText(  god.getPersonName()  );
                et_person_phone.setText( String.valueOf( god.getPersonPhone() ) );
                et_go_out_time.setText( god.getGodsGoOutTime() );
                et_return_time.setText( god.getGodsReturnTime() );

            }

        }



    }

    private void initView() {

        et_gods_number = findViewById( R.id.et_gods_number );
        et_gods_name = findViewById( R.id.et_gods_name );
        et_person_name = findViewById( R.id.et_person_name );
        et_person_phone = findViewById( R.id.et_person_phone );
        et_go_out_time = findViewById( R.id.et_go_out_time );
        et_return_time = findViewById( R.id.et_return_time );

        btnCancel =findViewById( R.id.btn_cancel );
        btnSave = findViewById( R.id.btn_save );
        btnCancel.setOnClickListener( this );
        btnSave.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_save:
                updateGod();
                break;
            case R.id.btn_cancel:
                finish();

        }

    }

    private void updateGod() {

        {

            if(god == null) {
                god = new God();
            }
            god.setGodsNumber(et_gods_number.getText().toString());
            god.setGodsName(et_gods_name.getText().toString());
            god.setPersonName(et_person_name.getText().toString());
            god.setPersonPhone(Integer.parseInt(et_person_phone.getText().toString()));
            god.setGodsGoOutTime(et_go_out_time.getText().toString());
            god.setGodsReturnTime(et_return_time.getText().toString());

            if("修改".equals(flag)) {
                godService.modifyPersonName(god);
            } else if("添加".equals(flag)) {
                godService.insert(god);
            }

            // 将修改的数据返回MainActivity
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("god", god);
            intent.putExtras(bundle);
            setResult( Activity.RESULT_OK, intent);
            finish();
        }


    }
}
