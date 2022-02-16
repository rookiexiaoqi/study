package com.example.studydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import androidx.appcompat.app.AppCompatActivity;

public class BrodcastTest extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brodcast_test);
        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
        Button button1= findViewById(R.id.button_broadcast);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.broadcasttest.MY_BROADCAST");
                save();
                sendBroadcast(intent);
            }
        });
    }
    public void save(){
        String data="data to save";
        FileOutputStream out =null;
        BufferedWriter writer=null;
        Log.d("BrodcastTest","save运行了哦");
        try {
            out=openFileOutput("data",Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
            Log.d("BrodcastTest","try运行了哦");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            Log.d("BrodcastTest","finally运行了哦");
            try {
                if (writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null&& networkInfo.isAvailable()){
                Toast.makeText(context,"network is available",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(context,"network is unavailable",Toast.LENGTH_LONG).show();
            }
        }
    }

}