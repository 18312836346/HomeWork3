package com.example.homework.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.homework.R;
import com.example.homework.adapter.VGridAdapter;
import com.example.homework.service.ThreeService;

import java.util.ArrayList;
import java.util.List;


public class First2Fragment extends Fragment  {

    private GridView SgridView;

    public First2Fragment() {

    }


    public static First2Fragment newInstance() {
        First2Fragment fragment = new First2Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate( R.layout.fragment_first2, container, false );
        setHasOptionsMenu( true );
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "学生公寓管理系统" );

        initData();
        //2.初始化listview
        SgridView = view.findViewById(R.id.s_gridView);
        initView();
        return view;
    }

    private void initView() {
        SgridView.setAdapter(new VGridAdapter(services,getContext()));
        SgridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThreeService service = (ThreeService) adapterView.getItemAtPosition(i);

            }
        });
    }

    private List<ThreeService> services;
    private void initData() {
        services = new ArrayList<>();
        services.add(new ThreeService(R.mipmap.stu1, ""));
        services.add(new ThreeService(R.mipmap.stu2, ""));
        services.add(new ThreeService(R.mipmap.stu3, ""));
        services.add(new ThreeService(R.mipmap.stu4, ""));


    }
}
