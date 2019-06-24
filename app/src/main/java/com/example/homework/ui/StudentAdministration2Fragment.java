package com.example.homework.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;
import com.example.homework.adapter.GridAdapter;
import com.example.homework.service.ThreeService;

import java.util.ArrayList;
import java.util.List;


public class StudentAdministration2Fragment extends Fragment  {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private GridView gridView;
    private TextView texxx;


    public StudentAdministration2Fragment() {
    }


    public static StudentAdministration2Fragment newInstance() {
        StudentAdministration2Fragment fragment = new StudentAdministration2Fragment();

        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate( R.layout.fragment_student_administration2, container, false );
        setHasOptionsMenu( true );
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "学生个人信息管理" );


        //1.初始化数据
        initData();
        //2.初始化listview
        texxx = view.findViewById(R.id.texxx);
        gridView = view.findViewById(R.id.gridView3);
        initView();

        return view;
    }

    private void initView() {

        Bundle dataBundle = getActivity().getIntent().getExtras();
        final String result = dataBundle.getString("用户名");


        gridView.setAdapter(new GridAdapter(services,getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThreeService service = (ThreeService) adapterView.getItemAtPosition(i);
                if (i==0){
                    Intent intent = new Intent(getActivity(), StudentInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("用户名", result);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                if (i==1){
                    Intent intent = new Intent(getActivity(), UpdateActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("用户名", result);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                Toast.makeText(getContext(),service.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<ThreeService> services;
    private void initData() {
        services = new ArrayList<>();
        services.add(new ThreeService(R.mipmap.xueshengzhusuxinxiguanli,"个人信息"));
        services.add(new ThreeService(R.mipmap.churuguanli,"账号安全"));
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
