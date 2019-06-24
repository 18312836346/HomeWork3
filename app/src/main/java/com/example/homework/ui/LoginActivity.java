package com.example.homework.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RadioGroup;

import com.example.homework.R;

public class LoginActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener{


    //相当于java的HashMap
    private SparseArray<Fragment> fragments2;
    //组
    private RadioGroup group2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initFragment();
        initView();
    }



    //按钮组
    private void initView() {
        group2 =findViewById( R.id.btn_group2 );
        group2.setOnCheckedChangeListener( this );
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        replaceFragment( fragments2.get( checkedId ) );//id是RadioButton的id
    }

    private void initFragment() {
        //将创建的放入集合中，将页面定位为第一个Fragment
        fragments2 =new SparseArray<>(  );
        fragments2.put( R.id.btn_stu_login, StudentLoginFragment.newInstance());
        fragments2.put( R.id.btn_admin_login, AdministrationLoginFragment.newInstance() );

        //优先显示界面
        replaceFragment(fragments2.get( R.id.btn_stu_login ));
    }



    //功能：对多个fragment进行管理和替换
    private void replaceFragment(Fragment fragment2) {
        //1、获取对象
        FragmentManager manager =getSupportFragmentManager();
        //2、
        FragmentTransaction ft = manager.beginTransaction();
        //3、
        ft.replace( R.id.content_layout2,fragment2 );
        //4、
        ft.commit();

    }


}
