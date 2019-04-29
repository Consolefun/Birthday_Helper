package com.example.birthday_helper;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Sport_channel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_channel);
        Toolbar toolbar = findViewById(R.id.toolbarsport);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sports");
    }
    public void open_espn(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.espn.com/"));
        startActivity(browserIntent);
    }
    public void open_NFL(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nfl.com/redzonetv"));
        startActivity(browserIntent);
    }
    public void open_foxsport(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.foxsports.com/"));
        startActivity(browserIntent);
    }
    public void open_nbc(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nbcsports.com/"));
        startActivity(browserIntent);
    }

}
