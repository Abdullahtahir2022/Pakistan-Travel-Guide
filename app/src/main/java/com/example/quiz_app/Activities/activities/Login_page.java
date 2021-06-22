package com.example.quiz_app.Activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.Task;

import static android.widget.Toast.LENGTH_SHORT;

public class Login_page extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btn;
        TextView btn_transition;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        firebaseAuth = FirebaseAuth.getInstance();
        btn = findViewById(R.id.buttonlogin);
        btn_transition = findViewById(R.id.logintosignup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        btn_transition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_page.this, SignupPage.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void login(){
        EditText email;
        EditText password;

        email = findViewById(R.id.emaillogin);
        password = findViewById(R.id.passwordlogin);


        String email_login = email.getText().toString();
        String password_login = password.getText().toString();




        if(email_login.isEmpty() || password_login.isEmpty()){
            Toast.makeText(this,"Fields can't be left blank", LENGTH_SHORT).show();
            return;
        }
        if(password_login.length() < 8){
            Toast.makeText(this,"Password should be atleast 8 characters", LENGTH_SHORT).show();
            return;
        }


        firebaseAuth.signInWithEmailAndPassword(email_login,password_login)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login_page.this,"Login Successful", LENGTH_SHORT).show();
                            Intent intent = new Intent(Login_page.this, MainActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            Toast.makeText(Login_page.this,"Login Failed", LENGTH_SHORT).show();

                        }
                    }
                });





    }
}