package com.example.homework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.homework.R;
import com.example.homework.model.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_v_student, viewGroup, false);
            holder = new ViewHolder();

            holder.studentRoom = view.findViewById(R.id.student_room);
            holder.studentName = view.findViewById(R.id.student_name);
            holder.studentNumber = view.findViewById(R.id.student_number);
            holder.studentInstitute = view.findViewById(R.id.student_institute);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Student student = students.get(i);

        holder.studentRoom.setText(student.getStudentRoom());
        holder.studentName.setText(student.getStudentName());
        holder.studentNumber.setText(String.valueOf(student.getStudentNumber()));
        holder.studentInstitute.setText(student.getStudentInstitute());


        return view;
    }
    static class ViewHolder {
        TextView studentRoom;
        TextView studentName;
        TextView studentNumber;
        TextView studentInstitute;
    }
}
