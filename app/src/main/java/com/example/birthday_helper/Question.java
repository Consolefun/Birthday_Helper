package com.example.birthday_helper;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
//import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;


import java.util.Calendar;

import static com.example.birthday_helper.Birthday_Notifier.Notify_ID;

public class Question extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private NotificationManagerCompat notificationmanager;
    private EditText edit_hour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DATE);

                DatePickerDialog dialog = new DatePickerDialog(
                        Question.this,
                        android.R.style.Theme_DeviceDefault_Dialog_Alert,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date: " + month + "/" + dayOfMonth + "/" + year);

                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
            }
        };


        notificationmanager = NotificationManagerCompat.from(this);

        edit_hour = findViewById(R.id.edit_hours);


    }

    public void sendOnNotify(View v){

        String hour = edit_hour.getText().toString();
        Notification notification = new NotificationCompat.Builder(this,Notify_ID)
                .setSmallIcon(R.drawable.ic_cake_birthday)
                .setContentTitle(hour)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .build();

        notificationmanager.notify(1, notification);

    }
}
