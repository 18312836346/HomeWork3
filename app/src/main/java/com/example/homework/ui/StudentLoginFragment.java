package com.example.homework.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;
import com.example.homework.model.Sign;
import com.example.homework.model.Sign2;
import com.example.homework.service.Sign2Service;
import com.example.homework.service.SignService;


public class StudentLoginFragment extends Fragment implements View.OnClickListener {

    private TextView stSignin;
    private EditText evUsername2,evPassword2;
    private Button btnStudent;
    private Sign2Service service;
    private TextView tvSueccess2;

    public StudentLoginFragment() {

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static StudentLoginFragment newInstance() {
        StudentLoginFragment fragment = new StudentLoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate( R.layout.fragment_student_login, container, false );
        setHasOptionsMenu( true );
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "学生公寓管理系统" );
        tvSueccess2=view.findViewById(R.id.tv_sueccess2);
        stSignin=view.findViewById(R.id.stsignin);
        btnStudent=view.findViewById(R.id.btn_student);
        evUsername2=view.findViewById(R.id.ev_userName2);
        evPassword2=view.findViewById(R.id.ev_password2);
        btnStudent.setOnClickListener(this);
        stSignin.setOnClickListener(this);
        service = new Sign2Service(getContext());
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_student:
                Login();


                break;
            case R.id.stsignin:
                Intent intent1 = new Intent(getContext(), StudentSignInActivity.class);
                startActivity(intent1);
                break;
        }
    }




    private void Login() {
        Sign2 sign = new Sign2();
        sign.setUsername(evUsername2.getText().toString());
        sign.setPassword(evPassword2.getText().toString());
        // 2. 判断
        boolean result = service.login(sign);
        //
        //

        // 3. 跳转
        if(result) {
            Intent intent = new Intent(getContext(), Main2Activity.class);
            intent.putExtra("用户名", evUsername2.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(getContext(),"用户名或密码错误",Toast.LENGTH_LONG).show();
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
