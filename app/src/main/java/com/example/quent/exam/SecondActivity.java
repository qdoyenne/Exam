package com.example.quent.exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;


import com.example.quent.exam.models.ResponseGson;

/**
 * Created by quent on 22/03/2017.
 */

public class SecondActivity extends AppCompatActivity   {

    private static final String Informations_URL = "https://www.googleapis.com/youtube/v3/search";
    private RecyclerView recyclerView;
    public static String Video ="VIDEO";
    private String recherche;

    public static void start(Context context, String recherche) {
        Intent intent = new Intent((Context) context, SecondActivity.class);
        intent.putExtra(Video, recherche);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recherche= getIntent().getStringExtra(Video);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getVideos();
    }

    private void getVideos() {

        StringRequest videosRequest = new StringRequest(Informations_URL + "?part=snippet&q="+recherche+"&type=video&key=" + Constants.API_KEY, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response != null) {
                    ResponseGson videosGson = new Gson().fromJson(response, ResponseGson.class);
                    Log.d("test", String.valueOf(videosGson.getItems().size()));
                   // setAdapter(videosGson);
                }
            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Videos", "Error");
            }
        });

        Volley.newRequestQueue(this).add(videosRequest);
    }

    /*private void setAdapter(ResponseGson videosGson) {

        VideoAdapters adapter = new VideoAdapters(videosGson);
        adapter.setOnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);

    }*/
    /*
    @Override
    public void onVideoSelected(Item item){
        PlayerActivity.start(this, item);
        startActivity(new Intent(this, PlayerActivity.class));
    }*/


}
