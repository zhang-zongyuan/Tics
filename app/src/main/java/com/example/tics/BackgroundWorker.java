package com.example.tics;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    ArrayList<Variable> arrayList =new ArrayList<>();
    String json_url="http://192.168.154.166/get_stu.php";
//    AlertDialog alertDialog;
    public BackgroundWorker(Context context){
        this.context = context;

    }
        public ArrayList<Variable> getList () {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, json_url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while (count < response.length()) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                Variable variable = new Variable(jsonObject.getString("StudentName"), jsonObject.getString("StudentID"), jsonObject.getString("ClassID"));
                                arrayList.add(variable);
                                count++;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error" + arrayList, Toast.LENGTH_SHORT).show();
            }
        }
        );
        MySingleton.getInstance(context).addToRequest(jsonArrayRequest);
        return arrayList;
    }
    @Override
    protected String doInBackground(String... params) {
        String login_url = params[0];
        String type = params[1];
        String username = params[2];
        String password = params[3];
        String mail = params[4];
        String schName =params[5];
        String classID =params[6];
        try {

            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = "";
            if(type.equals("sign_up")) {
                post_data = URLEncoder.encode("TeacherName", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("TeacherPswd", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
            }
            else if(type.equals("update")){
                post_data = URLEncoder.encode("TeacherName", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("TeacherSchName", "UTF-8") + "=" + URLEncoder.encode(schName, "UTF-8")+ "&"
                        + URLEncoder.encode("TeacherMail", "UTF-8") + "=" + URLEncoder.encode(mail, "UTF-8")+ "&"
                        + URLEncoder.encode("ClassID", "UTF-8") + "=" + URLEncoder.encode(classID, "UTF-8");
            }
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
//
//    @Override
//    protected void onPreExecute() {
//        alertDialog = new AlertDialog.Builder(context).create();
//        alertDialog.setTitle("Login Status");
//    }
//
//    @Override
//    protected void onPostExecute(String result) {
//
//        alertDialog.setMessage(result);
//        alertDialog.show();
//        //Toast.makeText(context.getApplicationContext(),result,Toast.LENGTH_LONG).show();
//
//    }

}
