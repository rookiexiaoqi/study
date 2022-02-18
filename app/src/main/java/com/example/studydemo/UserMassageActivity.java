package com.example.studydemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class UserMassageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_massage2);
        SharedPreferences preferences=getSharedPreferences("用户个人信息",MODE_PRIVATE);
        String name=preferences.getString("name","");
        TextView title=findViewById(R.id.onetextview);
        title.setText(name+"的个人信息");
        Button button1=findViewById(R.id.twobutton);
        button1.setText("信息修改");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(UserMassageActivity.this,userMassage.class);
                startActivity(intent);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });
        String sex=preferences.getString("sex","");
        int age=preferences.getInt("age",0);
        String adress=preferences.getString("adress","");
        long tel=preferences.getLong("tel",0);
        long qq=preferences.getLong("qq",0);
        String email=preferences.getString("email","");
        String likingthing=preferences.getString("likingthings","");
        Log.d("UserMassageActivity",name+sex+age+adress+tel+qq+email+likingthing);
        TextView textView1=findViewById(R.id.name);
        textView1.setText(name);
        TextView textView2=findViewById(R.id.sex);
        textView2.setText(sex);
        TextView textView3=findViewById(R.id.age);
        textView3.setText(Integer.toString(age));
        TextView textView4=findViewById(R.id.address);
        textView4.setText(adress);
        TextView textView5=findViewById(R.id.tel_number);
        textView5.setText(Long.toString(tel));
        TextView textView6=findViewById(R.id.qq_number);
        textView6.setText(Long.toString(qq));
        TextView textView7=findViewById(R.id.e_mail);
        textView7.setText(email);
        TextView textView8=findViewById(R.id.liking_things);
        textView8.setText(likingthing);
        Button dataButton=findViewById(R.id.sqlbutton);
        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.sqlbutton:
                        Intent intent =new Intent(UserMassageActivity.this,BookCatalogue.class);
                        PendingIntent pendingIntent=PendingIntent.getActivities(UserMassageActivity.this,0, new Intent[]{intent},0);
                        NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        Notification notification=new NotificationCompat.Builder(UserMassageActivity.this)
                                .setContentTitle("书籍商城")
                                .setContentText("欢迎您浏览观阅书籍！")
                                .setWhen(System.currentTimeMillis())
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                                .setContentIntent(pendingIntent)
                                .setVibrate(new long[]{0,1000,1000,1000})
                                .setAutoCancel(true)
                                .build();
                        manager.notify(1,notification);
                        Log.d("UserMassageActivity","点击了通知");
                        finish();
                        break;
                    default:
                        break;
                }
                Log.d("UserMassageActivity","点击对了");
                Intent intent=new Intent(UserMassageActivity.this,BookCatalogue.class);
                startActivity(intent);
                finish();
            }
        });

    }
}