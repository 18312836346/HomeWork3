package com.example.homework.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.homework.R;
import com.example.homework.adapter.GridAdapter;
import com.example.homework.service.ThreeService;

import java.util.ArrayList;
import java.util.List;


public class FlagAdministrationFragment extends Fragment  {

    private GridView gridView;
    private String username;

    public FlagAdministrationFragment() {
    }

    public static FlagAdministrationFragment newInstance() {
        FlagAdministrationFragment fragment = new FlagAdministrationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate( R.layout.fragment_flag_administration, container, false );
        setHasOptionsMenu( true );
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "公寓管理" );


        Bundle bundle = getArguments();
        username = bundle.getString("username");
        //1.初始化数据
        initData();
        //2.初始化listview
        gridView = view.findViewById(R.id.gridView2);
        initView();
        return view;
    }


    private void initView() {
        gridView.setAdapter(new GridAdapter(services,getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThreeService service = (ThreeService) adapterView.getItemAtPosition(i);
                if (i==1){
                    Intent intent = new Intent(getActivity(), GodManageActivity.class);
                    startActivity(intent);
                }
                if (i==0){
                    Intent intent = new Intent(getActivity(), RoomSelectActivity.class);
                    startActivity(intent);
                }
                Toast.makeText(getContext(),service.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<ThreeService> services;
    private void initData() {
        services = new ArrayList<>();
        services.add(new ThreeService(R.mipmap.susheguanli,"宿舍管理"));
        services.add(new ThreeService(R.mipmap.wupingguanli,"物品出入管理"));
    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId( )) {
            case R.id.item_info:
                intent = new Intent(getActivity(), InfoActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
                break;
            case R.id.item_safcount:
                intent = new Intent(getActivity(), SafCountActivyty.class);
                intent.putExtra("username",username);
                startActivity(intent);
                break;
            case R.id.item_help:
                intent = new Intent(getActivity(), HelpActivity.class);
                startActivity(intent);
                break;
            case R.id.item_about:
                intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
