package com.example.tics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    Button classbtn, studentbtn,medicalhistbtn,gamebtn,sign_outbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        classbtn = (Button) findViewById(R.id.classbtn);
        studentbtn = (Button) findViewById(R.id.studentbtn);
        medicalhistbtn = (Button) findViewById(R.id.medicalhistbtn);
        gamebtn = (Button) findViewById(R.id.gamebtn);
        sign_outbtn = (Button) findViewById(R.id.sign_outbtn);

        classbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Home_class.class);
                startActivity(intent);
            }
        });
        studentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Class_stu.class);
                startActivity(intent);
            }
        });
        medicalhistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Med_hist.class);
                startActivity(intent);
            }
        });
        gamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Game_prog.class);
                startActivity(intent);
            }
        });
        sign_outbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Start_screen.class);
                startActivity(intent);
            }
        });
    }
}
