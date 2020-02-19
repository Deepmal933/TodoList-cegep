package com.example.todolist;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView user_name;
    private TextView letter;
    private TextView user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user_name = findViewById(R.id.user_name);
                user_email = findViewById(R.id.user_email);
letter = findViewById(R.id.letter);
                user_name.setText(Profile.NAME);
                user_email.setText(Profile.EMAIL);
                letter.setText(String.valueOf(Profile.NAME.charAt(0)).toUpperCase());



    }

}
