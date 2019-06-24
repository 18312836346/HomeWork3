package com.example.homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.homework.R;
import com.example.homework.service.ThreeService;

import java.util.List;

public class VGridAdapter extends BaseAdapter {

    private List<ThreeService> services;
    private Context context;

    public VGridAdapter(List<ThreeService> services, Context context) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_v_gridview,viewGroup,false);
            holder = new ViewHolder();
            holder.imgItem = view.findViewById(R.id.iv_image);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        ThreeService service = services.get(i);
        holder.imgItem.setImageResource(service.getImgId());
        return view;
    }

    static class ViewHolder{
        ImageView imgItem;
    }
}
