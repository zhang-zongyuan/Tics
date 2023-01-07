package com.example.tics;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class Class_stu extends AppCompatActivity{

public void go_class(){
    Intent intent = new Intent(Class_stu.this, Home_class.class);
    startActivity(intent);
}
}
