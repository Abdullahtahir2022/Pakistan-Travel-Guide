package com.example.quiz_app.Activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_app.Activities.adapters.P_adapter;
import com.example.quiz_app.Activities.utils.Tuple;
import com.example.quiz_app.Activities.utils.string_storage;
import com.example.quiz_app.R;
import android.os.Bundle;

import java.util.ArrayList;

public class transport extends AppCompatActivity {
    ArrayList<string_storage> transport = new ArrayList<string_storage>();
    ArrayList<Tuple>  Transport_cordinates = new ArrayList<Tuple>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        transport = (ArrayList<string_storage>) getIntent().getSerializableExtra("transport");
        Transport_cordinates = (ArrayList<Tuple>) getIntent().getSerializableExtra("Transport_cordinates");

        RecyclerView list  = findViewById(R.id.recycler);
        list.setLayoutManager(new GridLayoutManager(this,2));


        list.setAdapter(new P_adapter(this,transport,Transport_cordinates));


    }
}