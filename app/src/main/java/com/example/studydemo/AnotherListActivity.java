package com.example.studydemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class AnotherListActivity extends AppCompatActivity {
    private List<week> weekList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_list);
        initWeeks();//初始化数据
        weekAdapter weekAdapter=new weekAdapter(AnotherListActivity.this,R.layout.week_list,weekList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(weekAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                week week=weekList.get(i);
                Toast.makeText(AnotherListActivity.this,"今天的日期是："+getString(week.getWeekName())+"，今天我需要做的事是："+getString(week.getWeekContext()),Toast.LENGTH_LONG).show();
            }
        });
    }
    private void initWeeks(){
        for(int i=0;i<2;i++){
            week weekone=new week(R.string.week_one,R.string.week_one_do);
            weekList.add(weekone);
            week weektwo=new week(R.string.week_two,R.string.week_two_do);
            weekList.add(weektwo);
            week weekthree=new week(R.string.week_three,R.string.week_three_do);
            weekList.add(weekthree);
            week weekfour=new week(R.string.week_four,R.string.week_four_do);
            weekList.add(weekfour);
            week weekfive=new week(R.string.week_five,R.string.week_five_do);
            weekList.add(weekfive);
            week weeksix=new week(R.string.week_six,R.string.week_six_do);
            weekList.add(weeksix);
            week weekseven=new week(R.string.week_seven,R.string.week_seven_do);
            weekList.add(weekseven);

        }
    }
}