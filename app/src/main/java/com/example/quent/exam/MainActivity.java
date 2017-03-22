package com.example.quent.exam;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import android.view.View;

import com.example.quent.exam.Constants;



public class MainActivity extends AppCompatActivity {

    private static final String Informations_URL = "https://www.googleapis.com/youtube/v3/search";
    private RecyclerView recyclerView;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                final String request = editText.getText().toString();
                //SecondActivity.start(this, request);
            }
        });
    }
}

