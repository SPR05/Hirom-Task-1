package com.example.hiromtask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    private static final String JSON_URL = "https://jsonplaceholder.typicode.com/photos/";
    List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView =findViewById(R.id.listView);

        taskList = new ArrayList<>();

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String List = taskList.get(i).toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });*/

       loadTaskList();

        MyAdapter adapter = new MyAdapter(taskList, getApplicationContext());

        listView.setAdapter(adapter);
    }



     private void loadTaskList() {

      StringRequest stringRequest = new StringRequest(Request.Method.GET,JSON_URL,
              new Response.Listener<String>(){
          @Override
            public void onResponse(String response){



                try {
                    JSONObject obj = new JSONObject(response);

                    JSONArray taskArray = obj.getJSONArray("");

                    for (int i=0; i<taskArray.length();i++){
                        JSONObject taskObject = taskArray.getJSONObject(i);

                        Task task = new Task(taskObject.getString("albumId"),
                                taskObject.getString("id"),
                                taskObject.getString("title"),
                                taskObject.getString("url"),
                                taskObject.getString("thumbnailUrl"));

                        taskList.add(task);
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
                    public void onErrorResponse(VolleyError error){
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
                }
                );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}