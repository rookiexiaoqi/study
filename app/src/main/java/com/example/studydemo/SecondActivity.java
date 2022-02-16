package com.example.studydemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent1=getIntent();
        String data = intent1.getStringExtra("extra_data");
        Log.d("SecondActivity",data);
        Button anotherButton=findViewById(R.id.another_button);
        anotherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.putExtra("data_ruturn","这是需要返回给上一个页面的内容");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        Button anotherButton2=findViewById(R.id.another_button_two);
        anotherButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}