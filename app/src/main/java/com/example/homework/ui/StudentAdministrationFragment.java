package com.example.homework.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.homework.R;
import com.example.homework.adapter.GridAdapter;
import com.example.homework.service.ThreeService;

import java.util.ArrayList;
import java.util.List;


public class StudentAdministrationFragment extends Fragment implements View.OnClickListener {

    private GridView gridView;
    private Button searchStudent;


    public StudentAdministrationFragment() {
    }


    public static StudentAdministrationFragment newInstance() {
        StudentAdministrationFragment fragment = new StudentAdministrationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate( R.layout.fragment_student_administration, container, false );
        setHasOptionsMenu( true );
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "学生信息管理" );

        //1.初始化数据
        initData();
        //2.初始化listview
        searchStudent = view.findViewById(R.id.search_student);
        searchStudent.setOnClickListener(this);
        gridView = view.findViewById(R.id.gridView1);
        initView();
        return view;
    }

    private void initView() {
        gridView.setAdapter(new GridAdapter(services,getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThreeService service = (ThreeService) adapterView.getItemAtPosition(i);
                if (i==0){
                    Intent intent = new Intent(getActivity(), StudentStayActivity.class);
                    startActivity(intent);
                }
                if (i==1){
                    Intent intent = new Intent(getActivity(), VipStudentActivity.class);
                    startActivity(intent);
                }
                Toast.makeText(getContext(),service.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<ThreeService> services;
    private void initData() {
        services = new ArrayList<>();
        services.add(new ThreeService(R.mipmap.xueshengzhusuxinxiguanli,"学生住宿信息管理"));
        services.add(new ThreeService(R.mipmap.churuguanli,"学生出入管理"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_student:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
