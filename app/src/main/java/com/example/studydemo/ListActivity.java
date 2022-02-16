package com.example.studydemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
    private String data[]={"星期一","星期二","星期三","星期四","星期五","星期六","星期日",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ListActivity.this,R.layout.support_simple_spinner_dropdown_item,data);
        ListView listView=findViewById(R.id.list_view);
        listView.setAdapter(adapter);


    }
}