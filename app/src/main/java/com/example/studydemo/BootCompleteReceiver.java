package com.example.studydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d("BootCompleteReceiver","广播接收器有在运行哦");
        Toast.makeText(context,"boot complate",Toast.LENGTH_LONG).show();

    }
}