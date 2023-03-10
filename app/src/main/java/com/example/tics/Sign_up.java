package com.example.tics;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sign_up extends AppCompatActivity {
//    public static final String EXTRA_NAME="name";
//    public static final String EXTRA_PSWD="pswd";
    private Button button;
    private EditText editTextUsername;
    private EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUsername=findViewById(R.id.username1);
        editTextPassword=findViewById(R.id.password1);
        button =(Button) findViewById(R.id.signupbtn);

        editTextUsername.addTextChangedListener(input_watcher);
        editTextPassword.addTextChangedListener(input_watcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String email= "";
                String schName= "";
                String classID= "";
                String url = "http://192.168.31.243/insertData.php";
                String type = "sign_up";
                BackgroundWorker backgroundWorker = new BackgroundWorker(Sign_up.this);
                backgroundWorker.execute(url, type, username, password,email,schName,classID);
                gt_success();
            }
        });
    }

    private void gt_success() {
        Intent intent = new Intent(Sign_up.this, Success.class);
        startActivity(intent);
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
}