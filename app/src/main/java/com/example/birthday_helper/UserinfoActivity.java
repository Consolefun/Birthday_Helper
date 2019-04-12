package com.example.birthday_helper;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

public class UserinfoActivity extends AppCompatActivity {
EditText etitle;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_userinfo);
    Toolbar toolbar = findViewById(R.id.toolbar_userinfo);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("User Information");
    etitle = findViewById(R.id.etTitle1);
    String passback = etitle.getText().toString();

    Intent intent = getIntent();
    String fname = intent.getStringExtra(Intent.EXTRA_TEXT);
    etitle.setText(fname);


  }

}