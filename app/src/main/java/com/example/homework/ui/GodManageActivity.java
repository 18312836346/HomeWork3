package com.example.homework.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.homework.R;
import com.example.homework.adapter.GodAdapter;
import com.example.homework.model.God;
import com.example.homework.service.GodService;
import com.example.homework.service.GodServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class GodManageActivity extends AppCompatActivity  {
    private static final int ADD_REQUEST = 100;
    private static final int MODIFY_REQUEST = 101;


    private ListView godList;
    private List<God> gods;

    private GodAdapter godAdapter;
    private GodService godService;

    private int selectedPos;
    private God selectedGod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_god_manage);
        // 从SQLite数据库获取数据
        initData();
        initView();
    }

    private void initView() {

        {

            godList=findViewById( R.id.lv_gods );
            godAdapter=new GodAdapter( gods,this );
            godList.setAdapter( godAdapter );

            // 设置ListView的点击和长按的事件监听
            godList.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                    // 将数据传递到godActivity界面显示
                    selectedPos = position;
                    selectedGod = (God) parent.getItemAtPosition(position);


                    Intent intent = new Intent(GodManageActivity.this, GodActivity.class);
                    intent.putExtra("flag", "修改");

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("god", selectedGod);
                    intent.putExtras(bundle);

                    startActivityForResult(intent, MODIFY_REQUEST );

                }
            } );

            //长按删除
            godList.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView <?> parent, View view, final int position, long id) {

                    // 利用AlertDialog弹出警告对话框，确认是否删除
                    selectedGod = (God) parent.getItemAtPosition(position);

                    new AlertDialog.Builder(GodManageActivity.this).setTitle("删除")
                            .setMessage("确认删除？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    // 从SQLite数据库的表中删除
                                    godService.delete(selectedGod.getGodsNumber());
                                    // 移除gods中的数据，并刷新adapter
                                    gods.remove(position);
                                    godAdapter.notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("取消", null)
                            .show();
                    return true;
                }
            } );



        }
    }

    private void initData() {
        // 从SQLite数据库获取物品列表
        godService = new GodServiceImpl(this);
        gods = godService.getAllGods();

        // 若数据库中没数据，则初始化数据列表，防止ListView报错
        if(gods == null) {
            gods = new ArrayList<>();
        }



    }

    // 接收GodActivity的返回的添加或修改后的god对象，更新gods，刷新列表
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            // 更新gods列表
            selectedGod = (God) bundle.get("god");
            if (requestCode == MODIFY_REQUEST) {
                gods.set(selectedPos, selectedGod);
            } else if (requestCode == ADD_REQUEST) {
                gods.add(selectedGod);
            }
            // 刷新ListView
            godAdapter.notifyDataSetChanged();
        }
    }

    // 创建添加功能的选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 动态加载菜单
        MenuItem item = menu.add(Menu.FIRST, 1, Menu.NONE, "添加");
        item.setIcon(android.R.drawable.ic_menu_add);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    // 处理选项菜单的添加功能
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case Menu.FIRST:
                // 跳转到GodActivity页面进行添加，flag用于存储是添加还是修改
                Intent intent = new Intent(GodManageActivity.this, GodActivity.class);
                intent.putExtra("flag", "添加");
                startActivityForResult(intent, ADD_REQUEST);
                break;


        }

        return super.onOptionsItemSelected( item );
    }
}
