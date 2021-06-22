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

public class SignupPage extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btn;
        TextView btn_transition;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        firebaseAuth = FirebaseAuth.getInstance();
        btn = findViewById(R.id.buttonsignup);
        btn_transition = findViewById(R.id.signuptoogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        btn_transition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupPage.this, Login_page.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void signup(){
        EditText email;
        EditText password;
        EditText cpassword;

        email = findViewById(R.id.emailsignup);
        password = findViewById(R.id.passwordsignup);
        cpassword = findViewById(R.id.cpasswordsignup);


        String email_signup = email.getText().toString();
        String password_signup = password.getText().toString();
        String cpassword_signup = cpassword.getText().toString();





        if(email_signup.isEmpty() || password_signup.isEmpty() || cpassword_signup.isEmpty()){
            Toast.makeText(this,"Fields can't be left blank", LENGTH_SHORT).show();
            return;
        }
        if(password_signup.length() < 8){
            Toast.makeText(this,"Password should be atleast 8 characters", LENGTH_SHORT).show();
            return;
        }


        firebaseAuth.createUserWithEmailAndPassword(email_signup,password_signup)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignupPage.this,"Signup Successful", LENGTH_SHORT).show();
                            Intent intent = new Intent(SignupPage.this, MainActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            Toast.makeText(SignupPage.this,"Error creating user", LENGTH_SHORT).show();

                        }
                    }
                });





    }


}