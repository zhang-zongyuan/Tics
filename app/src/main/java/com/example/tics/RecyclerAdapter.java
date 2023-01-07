package com.example.tics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
        ArrayList<Variable> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Variable> arraylist)
    {
        this.arrayList = arraylist;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.stu_row,parent,false);
        MyViewHolder myViewHolder =new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.studentName.setText(arrayList.get(position).getStudentName());
        holder.studentID.setText(arrayList.get(position).getStudentID());
        holder.classID.setText(arrayList.get(position).getClassID());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView studentName,studentID,classID;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName=(TextView) itemView.findViewById(R.id.stdname);
            studentID=(TextView)  itemView.findViewById(R.id.stuID);
            classID=(TextView) itemView.findViewById(R.id.classID);
        }
    }
}


