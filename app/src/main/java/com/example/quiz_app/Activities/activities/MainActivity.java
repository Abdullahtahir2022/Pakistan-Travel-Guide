package com.example.quiz_app.Activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quiz_app.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView lahore = (ImageView) findViewById(R.id.lahore);
        lahore.setOnClickListener(this); // calling onClick() method
        ImageView karachi = (ImageView) findViewById(R.id.karachi);
        karachi.setOnClickListener(this);
        ImageView peshawar = (ImageView) findViewById(R.id.peshawar);
        peshawar.setOnClickListener(this);
        ImageView quetta = (ImageView) findViewById(R.id.quetta);
        quetta.setOnClickListener(this);
        ImageView islamabad = (ImageView) findViewById(R.id.islamabad);
        islamabad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, cities.class);
        switch (v.getId()) {

            case R.id.lahore:
                intent.putExtra("city","lahore");
                startActivity(intent);

                break;

            case R.id.peshawar:
                intent.putExtra("city","peshawar");
                startActivity(intent);

                break;

            case R.id.quetta:
                intent.putExtra("city","quetta");
                startActivity(intent);

                break;


            case R.id.islamabad:
                intent.putExtra("city","islamabad");
                startActivity(intent);

                break;

            case R.id.karachi:
                intent.putExtra("city","karachi");
                startActivity(intent);

                break;

            default:
                break;
        }


    }
}