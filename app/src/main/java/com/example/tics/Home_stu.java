package com.example.tics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Home_stu extends AppCompatActivity {
        ImageButton button;
        Spinner spinner;
        String[] items={};
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home_stu);
            spinner = findViewById(R.id.stu_list);
            button = findViewById(R.id.menu);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Home_stu.this, android.R.layout.simple_spinner_item, items);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(Home_stu.this, Class_stu.class);
                    startActivity(intent);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Home_stu.this, Menu.class);
                    startActivity(intent);
                }
            });
        }
    }
