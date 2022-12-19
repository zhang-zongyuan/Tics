package com.example.tics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class Sign_up_profile extends AppCompatActivity {

    Spinner spinner;

    String[] items= {"school A","school B","school C","school D","school E","school F"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_profile);
        spinner=findViewById(R.id.school_list);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Sign_up_profile.this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String value=adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(Sign_up_profile.this,value, Toast.LENGTH_SHORT).show();
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}