package com.example.homework.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RadioGroup;

import com.example.homework.R;

public class Main2Activity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener{


    //相当于java的HashMap
    private SparseArray<Fragment> fragments3;
    //组
    private RadioGroup group3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initData();
        initFragment();
        initView();
    }

    private void initData() {
        Intent intent = getIntent();
        String classmate = intent.getStringExtra("用户名");
        String result = classmate;

        StudentAdministration2Fragment myFragment = new StudentAdministration2Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("用户名",result);//这里的values就是我们要传的值
        myFragment.setArguments(bundle);

    }


    //按钮组
    private void initView() {
        group3 =findViewById( R.id.btn_group3 );
        group3.setOnCheckedChangeListener( this );




    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        replaceFragment( fragments3.get( checkedId ) );//id是RadioButton的id
    }



    private void initFragment() {

        Intent intent = getIntent();
        String classmate = intent.getStringExtra("用户名");
        String result = classmate;
        //将创建的放入集合中，将页面定位为第一个Fragment
        fragments3 =new SparseArray<>(  );
        fragments3.put( R.id.btn_firpge2, First2Fragment.newInstance());
        fragments3.put( R.id.btn_stu_manage2, StudentAdministration2Fragment.newInstance() );
        replaceFragment(fragments3.get( R.id.btn_firpge2 ));
    }



    //功能：对多个fragment进行管理和替换
    private void replaceFragment(Fragment fragment) {
        //1、获取对象
        FragmentManager manager =getSupportFragmentManager();
        //2、
        FragmentTransaction ft = manager.beginTransaction();
        //3、
        ft.replace( R.id.content_layout3,fragment );
        //4、
        ft.commit();

    }


}
