package com.example.quiz_app.Activities.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.quiz_app.Activities.adapters.quiz_adapter;
import com.example.quiz_app.Activities.models.Question;
import com.example.quiz_app.Activities.models.Quiz;
import com.example.quiz_app.R;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SplittableRandom;

@RequiresApi(api = Build.VERSION_CODES.R)
public class MainActivity extends AppCompatActivity {


    ActionBarDrawerToggle actionBarDrawerToggle;
    private List<Quiz> quiz = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupviews();
        getSupportActionBar().setTitle("IQ Master");

    }




    private  void setupviews()
    {

        setupdrawer();
        setupRecycleeView();

    }

    private void setupRecycleeView(){
        RecyclerView quizRecyclerview = findViewById(R.id.Rview);
        quizRecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        String[] quiz1= {"Java","Python","Math","OOP","DB Systems","IR","ML","AI","NM","Probability","Web Tech","Coding"};

        quiz.add(new Quiz("1","Abdullah"));
        quiz.add(new Quiz("2","Manzoor"));
        quiz.add(new Quiz("3","Tallat"));
        quiz.add(new Quiz("4","Talha"));



        quizRecyclerview.setAdapter(new quiz_adapter(quiz));


    }

    private void setupdrawer(){
        MaterialToolbar bar;
        DrawerLayout drawer;
        drawer = findViewById(R.id.drawer);
        bar = findViewById(R.id.AppBar);
        setSupportActionBar(bar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer,R.string.app_name,R.string.app_name);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}