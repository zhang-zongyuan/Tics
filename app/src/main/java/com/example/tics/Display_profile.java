package com.example.tics;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Display_profile extends AppCompatActivity{
    Button button;
    TextView username,email,class1,school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);
        button = findViewById(R.id.completebtn);
        username = findViewById(R.id.username_profile);
        email = findViewById(R.id.email);
        class1 = findViewById(R.id.class1);
        school = findViewById(R.id.school);

        Intent receiveIntent = getIntent();
        String receivedValue = receiveIntent.getStringExtra("PROF_SENDER");

        getTeachDetails(receivedValue);
    }
        private void getTeachDetails(String recievedVlaue) {
            String url = "http://192.168.154.166/get_pro.php";

            // creating a new variable for our request queue
            RequestQueue queue = Volley.newRequestQueue(Display_profile.this);

            // on below line we are calling a string
            // request method to post the data to our API
            // in this we are calling a post method.
            StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        // on below line passing our response to json object.
                        JSONObject jsonObject = new JSONObject(response);
                        // on below line we are checking if the response is null or not.
                        if (jsonObject.getString("TeacherSchName") == null) {
                            // displaying a toast message if we get error
                            Toast.makeText(Display_profile.this, "didnt recieve data.", Toast.LENGTH_SHORT).show();
                        } else {
                            // if we get the data then we are setting it in our text views in below line.
                            username.setText(recievedVlaue);
                            school.setText(jsonObject.getString("TeacherSchName"));
                            class1.setText(jsonObject.getString("ClassID"));
                            email.setText(jsonObject.getString("TeacherMail"));
                        }
                        // on below line we are displaying
                        // a success toast message.
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // method to handle errors.
                    Toast.makeText(Display_profile.this, "Fail to get course" + error, Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    // as we are passing data in the form of url encoded
                    // so we are passing the content type below
                    return "application/x-www-form-urlencoded; charset=UTF-8";
                }

                @Override
                protected Map<String, String> getParams() {

                    // below line we are creating a map for storing our values in key and value pair.
                    Map<String, String> params = new HashMap<String, String>();

                    // on below line we are passing our key and value pair to our parameters.
                    params.put("TeacherName", recievedVlaue);

                    // at last we are returning our params.
                    return params;
                }
            };
            // below line is to make
            // a json object request.
            queue.add(request);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Display_profile.this, Menu.class);
                    startActivity(intent);
                }
            });
        }
}



        // url to post our data
//        String url = "http://192.168.31.243/fetch.php";
