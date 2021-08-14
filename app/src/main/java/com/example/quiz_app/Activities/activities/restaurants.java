package com.example.quiz_app.Activities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.quiz_app.Activities.adapters.P_adapter;
import com.example.quiz_app.R;

import java.util.ArrayList;
import com.example.quiz_app.Activities.utils.Tuple;
import com.example.quiz_app.Activities.utils.string_storage;
public class restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Tuple> hostel_coordinates = new ArrayList<Tuple>();
        ArrayList<string_storage>  hotels = new ArrayList<string_storage>();


        hostel_coordinates = (ArrayList<Tuple>) getIntent().getSerializableExtra("hostel_coordinates");
        hotels = (ArrayList<string_storage>) getIntent().getSerializableExtra("hotels");







        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        RecyclerView list  = findViewById(R.id.recycler);
        list.setLayoutManager(new GridLayoutManager(this,2));
        list.setAdapter(new P_adapter(this,hotels,hostel_coordinates));


}
    }
