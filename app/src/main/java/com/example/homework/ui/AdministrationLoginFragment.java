package com.example.homework.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.example.homework.service.SignService;


public class AdministrationLoginFragment extends Fragment implements View.OnClickListener {


    private TextView vipSignin;
    private EditText evUsername,evPassword;
    private Button btnAdministration;
    private SignService service;
    private TextView tvSueccess;
    private Sign signUser;

    public AdministrationLoginFragment() {

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static AdministrationLoginFragment newInstance() {
        AdministrationLoginFragment fragment = new AdministrationLoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate( R.layout.fragment_administration_login, container, false );
        setHasOptionsMenu( true );
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "学生公寓管理系统" );
        tvSueccess=view.findViewById(R.id.tv_sueccess);
        vipSignin=view.findViewById(R.id.vipsignin);
        btnAdministration=view.findViewById(R.id.btn_administration);
        evUsername=view.findViewById(R.id.ev_userName);
        evPassword=view.findViewById(R.id.ev_password);
        btnAdministration.setOnClickListener(this);
        vipSignin.setOnClickListener(this);
        service = new SignService(getContext());
        return view;

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_administration:
                Login();
                break;
            case R.id.vipsignin:
                Intent intent1 = new Intent(getContext(), VipSignInActivity.class);
                startActivity(intent1);
                break;
        }
    }

    private void Login() {
        Sign sign = new Sign();
        sign.setUsername(evUsername.getText().toString());
        sign.setPassword(evPassword.getText().toString());
        // 2. 判断
        boolean result = service.login(sign);
        // 3. 跳转
        if(result) {
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.putExtra("用户名", evUsername.getText().toString());
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
