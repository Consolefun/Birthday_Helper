package com.example.birthday_helper;


import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Chillrelax_activity_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chillrelax);
        Toolbar toolbar = findViewById(R.id.toolbar_chillrelax);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chill and Relax");
    }
    public void open_facebook(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
        startActivity(browserIntent);
    }
    public void open_netflix(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.netflix.com"));
        startActivity(browserIntent);
    }
    public void open_hulu(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hulu.com"));
        startActivity(browserIntent);
    }
    public void open_youtube(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
        startActivity(browserIntent);
    }

}
