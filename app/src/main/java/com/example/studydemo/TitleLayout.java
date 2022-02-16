package com.example.studydemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Class:TitleLayout
 *
 * @author: rookiexiaoqi
 * Description:
 * @Date: 2022/2/11
 * 四川农信 Rem is the best in the world
 */

//运行不了 nnnd
public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("TitleLayout","我是被用了的");
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button button1 = findViewById(R.id.onebutton);
        Button button2 =findViewById(R.id.twobutton);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TitleLayout","我有被点到哦");
                Toast.makeText(getContext(),"不要乱点别的东西呀，啊喂！",Toast.LENGTH_LONG).show();
            }
        });
    }

}
