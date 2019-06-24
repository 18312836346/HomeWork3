package com.example.homework.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.homework.R;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener{




    //相当于java的HashMap
    private SparseArray<Fragment> fragments;
    //组
    private RadioGroup group;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        if (username ==null){
            Toast.makeText(MainActivity.this,"没有拿到登陆信息",Toast.LENGTH_LONG).show();
        }

        initFragment();
        initView();
    }



    //创建选项菜单OptionMenu
//    @Override
//    public boolean onCreateOptionsMenu(android.view.Menu menu) {
//        getMenuInflater().inflate(R.menu.talk, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//
//
//        处理选项菜单的点击事件
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.menu_talk:
//                Toast.makeText(MainActivity.this,"点击了注销",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.menu_friend:
//                Toast.makeText(MainActivity.this,"退出",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.menu_sweep:
//                Toast.makeText(MainActivity.this,"个人信息",Toast.LENGTH_LONG).show();
//                break;
//            case R.id.menu_feedback:
//                Toast.makeText(MainActivity.this,"点击了收付款",Toast.LENGTH_LONG).show();
//                break;
//            default:
//                super.onOptionsItemSelected(item);
//                break;
//        }
//        return true;
//    }


//    显示头像
//    @Override
//    public boolean onMenuOpened(int featureId, android.view.Menu menu) {
//        if (menu != null) {
//            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
//                try {
//                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
//                    method.setAccessible(true);
//                    method.invoke(menu, true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return super.onMenuOpened(featureId, menu);
//    }



    //按钮组
    private void initView() {
        group =findViewById( R.id.btn_group );
        group.setOnCheckedChangeListener( this );

    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        replaceFragment( fragments.get( checkedId ) );//id是RadioButton的id
    }



    private void initFragment() {
        //将创建的放入集合中，将页面定位为第一个Fragment
        fragments =new SparseArray<>(  );

        fragments.put( R.id.btn_firpge, FirstPageFragment.newInstance());
        fragments.put( R.id.btn_stu_manage, StudentAdministrationFragment.newInstance() );
        fragments.put( R.id.btn_flag_manage, FlagAdministrationFragment.newInstance() );

        //优先显示界面
        replaceFragment(fragments.get( R.id.btn_firpge ));
    }

    //功能：对多个fragment进行管理和替换
    private void replaceFragment(Fragment fragment){
        //1.获取FragmentManager对象
        FragmentManager manager = getSupportFragmentManager();
        //2.开始FragmentTransaction的事务管理
        FragmentTransaction ft = manager.beginTransaction();
        //创建Bundle对象，将username传给fragment
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        fragment.setArguments(bundle);
        //3.替换为新的Fragment
        ft.replace(R.id.content_layout,fragment);//activity中LinearLayout的ID
        //4.事务提交
        ft.commit();
    }
}
