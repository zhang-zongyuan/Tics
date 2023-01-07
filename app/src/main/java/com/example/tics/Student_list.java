package com.example.tics;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Student_list extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Variable> arrayList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);
        recyclerView =(RecyclerView)findViewById(R.id.idRVCourses);
        layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        BackgroundWorker backgroundWorker =new BackgroundWorker(Student_list.this);
        arrayList =backgroundWorker.getList();
        adapter =new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
//    private void addtable() {
//        TableLayout stk =(TableLayout) findViewById(R.id.table_main);
//        TableRow tbrow0 =new TableRow(this);
//
//        TextView tv0= new TextView(this);
//        tv0.setText("Name");
//        tv0.setTextColor(Color.BLACK);
//        tv0.setGravity(Gravity.CENTER);
//        tbrow0.addView(tv0);
//
//        TextView tv1= new TextView(this);
//        tv1.setText("StudentID");
//        tv1.setTextColor(Color.BLACK);
//        tbrow0.addView(tv1);
//
//        TextView tv2= new TextView(this);
//        tv2.setText("Class");
//        tv2.setTextColor(Color.BLACK);
//        tbrow0.addView(tv2);
//
//        TextView tv3= new TextView(this);
//        tv3.setText("select");
//        tv3.setTextColor(Color.BLACK);
//        tbrow0.addView(tv3);
//
//        stk.addView(tbrow0);
//
//        for (int i=0; i<10; i++){
//            TableRow tbrow =new TableRow(this);
//            TextView t1v =new TextView(this);
//            t1v.setText("imported name" );
//            t1v.setGravity(Gravity.CENTER);
//            tbrow.addView(t1v);
//
//            TextView t2v =new TextView(this);
//            t2v.setText("imported studentID");
//            t2v.setGravity(Gravity.CENTER);
//            tbrow.addView(t2v);
//
//            TextView t3v = new TextView(this);
//            t3v.setText("imported Class");
//            t3v.setGravity(Gravity.CENTER);
//            tbrow.addView(t3v);
//
//            Button btn =new Button(this);
//            btn.setText("Go");
//            btn.setGravity(Gravity.CENTER);
//            tbrow.addView(btn);
//
//            stk.addView(tbrow);
//        }
//    }
}
