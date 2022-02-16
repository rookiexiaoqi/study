package com.example.studydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MyBroadcastReceiver","第二个广播接收器也有运行哦");
        Toast.makeText(context,"received in MyBroadcastReceiver",Toast.LENGTH_LONG).show();

    }
}