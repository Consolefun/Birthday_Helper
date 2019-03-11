package com.example.birthday_helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootNotifyMe extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotifyMe.init(context);
    }
}
