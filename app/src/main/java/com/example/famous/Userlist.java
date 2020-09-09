package com.example.famous;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Userlist extends AppCompatActivity {
 ListView listView;
    private List<Movie> movielist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        listView = (ListView) findViewById(R.id.list);
        movielist=new ArrayList<>();
        LoadList();
    }

    private void LoadList() {
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, "https://reqres.in/api/users?page=1", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listView.setVisibility(View.VISIBLE);
                Log.d("json", response.toString());
                try
                {
                    JSONArray jsonArray=response.getJSONArray( "movies");
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Movie item=new Movie();
                        item.setImage(jsonObject.getString("imageUrl"));
                        item.setName(jsonObject.getString("name"));
                        //adding the json data to list
                        movielist.add(item);
                    }
                    MoviesAdapter madapter=new MoviesAdapter(movielist,getApplicationContext());
                    listView.setAdapter(madapter);
                    madapter.notifyDataSetChanged();
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Myaplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
