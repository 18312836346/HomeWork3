package com.example.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.homework.R;
import com.example.homework.model.God;

import java.util.List;

public class GodAdapter extends BaseAdapter {


    private List <God> gods;
    private Context context;

    public GodAdapter(List <God> gods, Context context) {
        this.gods = gods;
        this.context = context;

    }

    @Override
    public int getCount() {
        return gods.size();
    }

    @Override
    public Object getItem(int position) {

        return gods.get( position );//获取position位置数据
    }

    @Override
    public long getItemId(int position) {

        return position;//获取item的索引位置position
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){

            //1、加载item_message.xml
            convertView = (View) LayoutInflater.from( context ).inflate( R.layout.item_gods ,null);

            //2、获取每个控件
            holder = new ViewHolder();
            holder.tvGodsNumber = convertView.findViewById( R.id.tv_gods_number );
            holder.tvGodsName = convertView.findViewById( R.id.tv_gods_name );
            holder.tvGoOutTime = convertView.findViewById( R.id.tv_go_out_time );
            holder.tvReturnTime = convertView.findViewById( R.id.tv_return_time );

            //3、将holder对象存储到view中
            convertView.setTag( holder );

        }else {//恢复

            holder= (ViewHolder) convertView.getTag();

        }
        //4、加载数据
        God god = gods.get(position);
        holder.tvGodsNumber.setText( god.getGodsNumber());
        holder.tvGodsName.setText( god.getGodsName() );
        holder.tvGoOutTime.setText(god.getGodsGoOutTime() );
        holder.tvReturnTime.setText( god.getGodsReturnTime());
        return convertView;

    }
    static  class ViewHolder{

        TextView tvGodsNumber;
        TextView tvGodsName;
        TextView tvGoOutTime;
        TextView tvReturnTime;

    }

}