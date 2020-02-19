package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private TextView user_name;
    private TextView user_pass;
    private Button login;
    private Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name = findViewById(R.id.user_email);
        user_pass = findViewById(R.id.user_pass);
        login=findViewById(R.id.login);
        Signup = findViewById(R.id.SignUp);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this,Register.class);
                startActivity(in);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_name.getText().equals("") || user_pass.getText().equals("")){
                    Toast.makeText(LoginActivity.this,"Please Enter User name Password",Toast.LENGTH_LONG).show();
                }
                else if(user_name.getText().toString().equals(Profile.EMAIL) && user_pass.getText().toString().equals(Profile.PASS)){
                    Intent in = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(in);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Invalid login",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
