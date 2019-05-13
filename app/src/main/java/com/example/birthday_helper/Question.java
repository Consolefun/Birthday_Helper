package com.example.birthday_helper;


import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.birthday_helper.NotifyMe;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import static java.util.Calendar.DAY_OF_MONTH;

public class Question extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Calendar now = Calendar.getInstance();
    TimePickerDialog tpd;
    DatePickerDialog dpd;
    EditText etTitle,hour_input,money_input;
    TextView mDisplayDate;
    TextView mDisplayTime;
    private SharedPreferences mpreference;
    private SharedPreferences.Editor editor;
    public static final String Share_pref = "Share_pref";
    public static final String key_count1 = "title ";
    public static final String key_count3 ="displaydate";
    public static final String key_count4 = "displaytime ";
    public static final String key_count5 = "hour ";
    public static final String key_count6 = "money ";
    String text,text2,text3,text4,text5;
    Button savebutton;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Button btnNotify = findViewById(R.id.btnNotify);
        etTitle = findViewById(R.id.etTitle);
        savebutton = (Button) findViewById(R.id.save_id);
        mDisplayTime = findViewById(R.id.Time_view);
        mDisplayDate=findViewById(R.id.Date_view);


        dpd = DatePickerDialog.newInstance(
                Question.this,

                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)

        );

        tpd = TimePickerDialog.newInstance(
                Question.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                false
        );

        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dpd.show(getFragmentManager(), "Datepickerdialog");
                savedata();
            }
        });

        Button btn_map = findViewById(R.id.entertainment_map);
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Entertainment_map.class);
                startActivity(intent);
            }
        });

        Button btn_activity = findViewById(R.id.chill_relax);
        btn_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chillrelax_activity_list.class);
                startActivity(intent);
            }
        });

        Button btn_food = findViewById(R.id.food_recipes);
        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), food.class);
                startActivity(intent);
            }
        });

        Button btn_sports = findViewById(R.id.sports_id);
        btn_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Sport_channel.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbarquestion);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Birthday Planner");
        loaddata();
        updatetext();


    }
    public void savedata(){
        mpreference = PreferenceManager.getDefaultSharedPreferences(Question.this);
        editor = mpreference.edit();
        editor.putString(key_count1, etTitle.getText().toString());
        editor.putString(key_count3, mDisplayDate.getText().toString());
        editor.putString(key_count4, mDisplayTime.getText().toString());

        editor.apply();
        editor.commit();
        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();

    }
    public void loaddata(){

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        text = sharedPreferences.getString(key_count1,"");
        text2 = sharedPreferences.getString(key_count3,"");
        text3 = sharedPreferences.getString(key_count4,"");

    }
    public void updatetext(){
        etTitle.setText(text);
        mDisplayDate.setText(text2);
        mDisplayTime.setText(text3);

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        now.set(Calendar.YEAR,year);
        now.set(Calendar.MONTH,monthOfYear);
        now.set(DAY_OF_MONTH,dayOfMonth);
        //mDisplayDate = (TextView) findViewById(R.id.Date_view);
        int month = monthOfYear+1;
        String text = "Your birthday is on ";
        date = text + month + "/" + dayOfMonth + "/" + year;

        tpd.show(getFragmentManager(), "Timepickerdialog");
        mDisplayDate.setText(date);

    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String am_pm="";
        String strHrsToShow = (now.get(Calendar.HOUR) == 0) ?"12":now.get(Calendar.HOUR)+"";

        now.set(Calendar.HOUR_OF_DAY,hourOfDay);
        now.set(Calendar.MINUTE,minute);
        now.set(Calendar.SECOND,second);
        Intent intent = new Intent(getApplicationContext(),Question.class);
        intent.putExtra("Userinfo_fragment","favoritesMenuItem");
        //mDisplayTime = (TextView) findViewById(R.id.Time_view);
        String text = " "+"at ";
        String time;

        if(now.get(Calendar.AM_PM)==Calendar.AM) {
            am_pm= "AM";
        }
        else if(now.get(Calendar.AM_PM) == Calendar.PM){
            am_pm = "PM";
        }
        time = text + strHrsToShow + ":" + minute + ":" + second + " "+ am_pm;
        mDisplayTime.setText(time);


        NotifyMe notifyMe = new NotifyMe.Builder(getApplicationContext())
                .title("Happy Birthday, "+etTitle.getText().toString())
                //.content(etContent.getText().toString())
                .content("Hope you are having a great day!")
                .color(255,0,0,255)
                .led_color(255,255,255,255)
                .time(now)
                //.addAction(intent,"Snooze",false)
                .key("test")
                .small_icon(R.drawable.ic_cake_birthday)
                .addAction(new Intent(),"Dismiss",true,false)
                .addAction(intent,"Done")
                .large_icon(R.mipmap.ic_birthcake_reminder)
                .build();

    }

}
