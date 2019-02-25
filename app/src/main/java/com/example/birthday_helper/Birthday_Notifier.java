package com.example.birthday_helper;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class Birthday_Notifier extends Application {

    public static final String Notify_ID = "Notify";
    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();

    }
    private void createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notify = new NotificationChannel(
                    Notify_ID,
                    "Notify",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notify.setDescription("This is channel notify");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notify);
        }
    }
}
