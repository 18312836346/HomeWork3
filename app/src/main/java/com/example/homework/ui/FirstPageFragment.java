package com.example.homework.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.homework.R;
import com.example.homework.adapter.VGridAdapter;
import com.example.homework.service.ThreeService;

import java.util.ArrayList;
import java.util.List;


public class FirstPageFragment extends Fragment  {

    private GridView VgridView;

    private TextView first1;

    public FirstPageFragment() {

    }


    public static FirstPageFragment newInstance() {
        FirstPageFragment fragment = new FirstPageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate( R.layout.firstpage_fragment, container, false );
        setHasOptionsMenu( true );
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "学生公寓管理系统" );

        initData();
        //2.初始化listview
        first1= view.findViewById(R.id.first);
        VgridView = view.findViewById(R.id.v_gridView);

//        String result = null;
//        Bundle bundle = this.getArguments();  // 获取Bundle对象
//        if(bundle != null) {
//            String classmate = bundle.getString("用户名");
//            result = classmate ;
//        }
//        first1.setText(result);
        initView();
        return view;
    }

    private void initView() {
        VgridView.setAdapter(new VGridAdapter(services,getContext()));
        VgridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThreeService service = (ThreeService) adapterView.getItemAtPosition(i);

            }
        });
    }

    private List<ThreeService> services;
    private void initData() {
        services = new ArrayList<>();
        services.add(new ThreeService(R.mipmap.stu1,""));
        services.add(new ThreeService(R.mipmap.stu2,""));
        services.add(new ThreeService(R.mipmap.stu3,""));
        services.add(new ThreeService(R.mipmap.stu4,""));

    }




    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
