package com.example.birthday_helper;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class UserinfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        Toolbar toolbar = findViewById(R.id.toolbar_userinfo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("User Information");
    }

}
