package com.example.birthday_helper;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState== null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new UserFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_userinfo);
        }
        /*if(savedInstanceState == null){
            Intent intent = new Intent(this, Question.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            startActivity(intent);
        }*/

    }
    // add these items to navigation view.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.nav_userinfo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UserFragment()).commit();
                break;
            case R.id.nav_entertainment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EntertainmentFragment()).commit();
                break;
            case R.id.nav_chillrelax:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChillrelaxFragment()).commit();
                break;

            case R.id.nav_share:
                Toast.makeText(this,"Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this,"Send", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_question:
                Intent intent1 = new Intent(this, Question.class);
                this.startActivity(intent1);
                return true;

        }
        drawer.closeDrawer(Gravity.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(Gravity.START);
        }
        else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater _inflater = getMenuInflater();
        _inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.about_id:
                Intent intent1 = new Intent(this, About.class);
                this.startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
