package com.example.studydemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class userMassage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_massage);
        TextView onetextview=findViewById(R.id.onetextview);
        onetextview.setText("个人信息");
        EditText editText1=findViewById(R.id.name);
        EditText editText2=findViewById(R.id.sex);
        EditText editText3=findViewById(R.id.age);
        EditText editText4=findViewById(R.id.address);
        EditText editText5=findViewById(R.id.tel_number);
        EditText editText6=findViewById(R.id.qq_number);
        EditText editText7=findViewById(R.id.e_mail);
        EditText editText8=findViewById(R.id.liking_things);
        Button complete=findViewById(R.id.complete);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                String sex = editText2.getText().toString();
                String age=editText3.getText().toString();
                String adress=editText4.getText().toString();
                String telNumber=editText5.getText().toString();
                String qqNumber=editText6.getText().toString();
                String eMmail=editText7.getText().toString();
                String likingThings=editText8.getText().toString();
                int userAge=Integer.valueOf(age).intValue();
                long userTelNumber=Long.parseLong(telNumber);
                long userQqNumber=Long.parseLong(qqNumber);
                /*sharedpreferences存储*/
                SharedPreferences preferences=getSharedPreferences("用户个人信息",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("name",name);
                editor.putString("sex",sex);
                editor.putInt("age",userAge);
                editor.putString("adress",adress);
                editor.putLong("tel",userTelNumber);
                editor.putLong("qq",userQqNumber);
                editor.putString("email",eMmail);
                editor.putString("likingthings",likingThings);
                editor.commit();
                Intent intent=new Intent(userMassage.this,UserMassageActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}