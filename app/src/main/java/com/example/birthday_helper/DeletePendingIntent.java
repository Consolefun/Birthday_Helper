package com.example.birthday_helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import static com.example.birthday_helper.Notification.NotificationEntry.TABLE_NAME;

public class DeletePendingIntent extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String notificationId = intent.getStringExtra("_id");
        com.example.birthday_helper.Notification.NotificationDBHelper mDbHelper = new com.example.birthday_helper.Notification.NotificationDBHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, com.example.birthday_helper.Notification.NotificationEntry._ID+" = "+notificationId,null);
        db.close();
    }
}
