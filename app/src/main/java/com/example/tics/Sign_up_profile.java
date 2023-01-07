package com.example.tics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Sign_up_profile extends AppCompatActivity {
    Button button;
    Spinner spinner,class_spin;
    TextView username;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name;
        List<String> school = Arrays.asList("school A","school B","school C","school D","school E","school F");
        List<String> classes = Arrays.asList("1","2","3","4","5");
        setContentView(R.layout.activity_sign_up_profile);
        spinner=findViewById(R.id.school_list);
        class_spin =findViewById(R.id.class_list);
        button = findViewById(R.id.completebtn);
        username =findViewById(R.id.username2);
        email=findViewById(R.id.email);

        Intent receiveIntent =getIntent();
        String receivedValue =receiveIntent.getStringExtra("KEY_SENDER");
        username.setText(receivedValue);

        ArrayAdapter adapter=new ArrayAdapter(Sign_up_profile.this, android.R.layout.simple_spinner_item,school);
        ArrayAdapter adapter1=new ArrayAdapter(Sign_up_profile.this, android.R.layout.simple_spinner_item,classes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        class_spin.setAdapter(adapter1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = receivedValue;
                String password = "";
                String schName = spinner.getSelectedItem().toString();
                String ClassID = class_spin.getSelectedItem().toString();
                String mail =email.getText().toString();
//                String url = "http://192.168.31.243/update_pro.php";
                String url = "http://192.168.154.166/update_pro.php";
                String type = "update";
                BackgroundWorker backgroundWorker = new BackgroundWorker(Sign_up_profile.this);
                backgroundWorker.execute(url, type, username, password,mail,schName,ClassID);
                Intent intent=new Intent(Sign_up_profile.this, Display_profile.class);
                startActivity(intent);
                Intent senderIntent= new Intent(getApplicationContext(), Display_profile.class);
                senderIntent.putExtra("PROF_SENDER",receivedValue);
                startActivity(senderIntent);
            }
        });

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                    String value=adapterView.getItemAtPosition(i).toString();
//                    Toast.makeText(Sign_up_profile.this,value, Toast.LENGTH_SHORT).show();
//                }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//        button.setOnClickListener(new View.OnClickListener(){
//        @Override
//        public void onClick(View view) {
//            Intent intent=new Intent(Sign_up_profile.this, Display_profile.class);
//            startActivity(intent);
//        }
//    });
    }
}