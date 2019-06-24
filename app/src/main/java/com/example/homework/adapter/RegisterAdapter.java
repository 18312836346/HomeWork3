package com.example.homework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.homework.R;
import com.example.homework.model.Room;
import com.example.homework.model.Student;
import com.example.homework.model.StudentRegister;

import java.util.List;

public class RegisterAdapter extends BaseAdapter {

    private List<StudentRegister> regisdters;
    public RegisterAdapter(List<StudentRegister> regisdters) {
        this.regisdters = regisdters;
    }
    @Override
    public int getCount() {
        return regisdters.size();
    }

    @Override
    public Object getItem(int i) {
        return regisdters.get(i);    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RegisterAdapter.ViewHolder holder;
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_v_student_register, viewGroup, false);
            holder = new RegisterAdapter.ViewHolder();

            holder.studentName = view.findViewById(R.id.student_name);
            holder.outTIme = view.findViewById(R.id.outtime);
            holder.destination = view.findViewById(R.id.destination);
            holder.intoTime = view.findViewById(R.id.intotime);

            view.setTag(holder);
        } else {
            holder = (RegisterAdapter.ViewHolder) view.getTag();
        }

        StudentRegister studentRegister = regisdters.get(i);

        holder.studentName.setText(studentRegister.getStudentName());
        holder.outTIme.setText(studentRegister.getOuttime());
        holder.destination.setText(studentRegister.getDestination());
        holder.intoTime.setText(studentRegister.getIntotime());


        return view;
    }
    static class ViewHolder {
        TextView studentName;
        TextView outTIme;
        TextView destination;
        TextView intoTime;
    }
}
