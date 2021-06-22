package com.example.quiz_app.Activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quiz_app.R;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Intro extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnintro;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__intro);
        btnintro = findViewById(R.id.buttonintro);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null){
            Toast.makeText(this,"Already logged in",Toast.LENGTH_SHORT).show();
            redirect("Main");
        }





        btnintro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect("Login");

            }
        });
    }

    private void redirect(String name){
        if(name == "Login"){
            Intent intent = new Intent(Login_Intro.this, Login_page.class);
            startActivity(intent);
            finish();

        }
        if(name == "Main"){
            Intent intent = new Intent(Login_Intro.this, MainActivity.class);
            startActivity(intent);
            finish();

        }

    }
}