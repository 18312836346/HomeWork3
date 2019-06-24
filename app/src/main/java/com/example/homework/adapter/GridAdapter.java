package com.example.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework.R;
import com.example.homework.service.ThreeService;

import java.util.List;

public class GridAdapter extends BaseAdapter {

    private List<ThreeService> services;
    private Context context;

    public GridAdapter(List<ThreeService> services, Context context) {
        this.services = services;
        this.context = context;
    }

    @Override
    public int getCount() {
        return services.size();
    }

    @Override
    public Object getItem(int i) {
        return services.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_gridview,viewGroup,false);
            holder = new ViewHolder();
            holder.imgItem = view.findViewById(R.id.iv_image);
            holder.tvName = view.findViewById(R.id.tv_text);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        ThreeService service = services.get(i);
        holder.imgItem.setImageResource(service.getImgId());
        holder.tvName.setText(service.getName());
        return view;
    }

    static class ViewHolder{
        ImageView imgItem;
        TextView tvName;
    }
}
