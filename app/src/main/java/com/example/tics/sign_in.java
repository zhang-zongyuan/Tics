package com.example.tics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class sign_in extends AppCompatActivity {
    private Button button;
    private EditText editTextUsername;
    private EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        Intent intent =getIntent();
        String uname=intent.getStringExtra(sign_up.EXTRA_NAME);
        String userpswd=intent.getStringExtra(sign_up.EXTRA_PSWD);

        TextView username=findViewById(R.id.username);
        TextView password=findViewById(R.id.password);

        button =(Button) findViewById(R.id.loginbtn);
        editTextUsername=findViewById(R.id.username);
        editTextPassword=findViewById(R.id.password);

        editTextUsername.addTextChangedListener(input_watcher);
        editTextPassword.addTextChangedListener(input_watcher);

        //admin and admin

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    //correct
                    //Toast.makeText(sign_in.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                    gt_profile();
                }
                else
                    Toast.makeText(sign_in.this,"Password or username is incorrect"+uname+" and "+userpswd,Toast.LENGTH_SHORT).show();
            }
        });
    }
    private TextWatcher input_watcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            String userNameInput= editTextUsername.getText().toString();
            String passwordInput= editTextPassword.getText().toString();

            button.setEnabled(!userNameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    public void gt_profile(){
        Intent intent = new Intent(sign_in.this, Sign_up_profile.class);
        startActivity(intent);
    }
}