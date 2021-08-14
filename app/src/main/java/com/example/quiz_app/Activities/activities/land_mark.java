package com.example.quiz_app.Activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quiz_app.Activities.adapters.P_adapter;
import com.example.quiz_app.Activities.utils.Tuple;
import com.example.quiz_app.Activities.utils.string_storage;
import com.example.quiz_app.R;

import java.util.ArrayList;

public class land_mark extends AppCompatActivity {
    ArrayList<Tuple>  land_coordinates = new ArrayList<Tuple>();
    ArrayList<string_storage>  land_marks = new ArrayList<string_storage>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_mark);
        land_marks = (ArrayList<string_storage>) getIntent().getSerializableExtra("land_marks");
        land_coordinates = (ArrayList<Tuple>) getIntent().getSerializableExtra("land_coordinates");
        RecyclerView list = findViewById(R.id.recycler);
        list.setLayoutManager(new GridLayoutManager(this,2));
        list.setAdapter(new P_adapter(this,land_marks,land_coordinates));
    }
}