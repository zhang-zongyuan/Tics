package com.example.tics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start_screen extends AppCompatActivity {
    private Button button;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        button =(Button) findViewById(R.id.sign_up1);
        button1= (Button) findViewById(R.id.sign_in1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignup();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignin();
            }
        });
    }
    public void opensignup() {
        Intent intent = new Intent(Start_screen.this, sign_up.class);
        startActivity(intent);
    }

    public void opensignin(){
        Intent intent = new Intent(Start_screen.this, sign_in.class);
        startActivity(intent);
    }
}