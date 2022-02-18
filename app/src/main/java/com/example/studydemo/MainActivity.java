package com.example.studydemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onrestart");
    }
    public void saveUserName(String inputContent){
        /*文件存储方式存储数据*/
        FileOutputStream out =null;
        BufferedWriter writer=null;
        Log.d("BrodcastTest","save运行了哦");
        try {
            out=openFileOutput("用户账号", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputContent);
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
    public void savePassword(String inputContent){
        FileOutputStream out =null;
        BufferedWriter writer=null;
        Log.d("BrodcastTest","save运行了哦");
        try {
            out=openFileOutput("用户密码", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputContent);
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
    public static boolean delFile(String filename){
        Boolean bool =false;
        String path="data/data/com.example.studydemo/files/";
        String fileTemp=path+filename;
        Log.d("MainActivity",fileTemp);
        File file=new File(fileTemp);
        try{
            if (file.exists()){
                file.delete();
                bool=true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return bool;
    };

    public String loadUserNumber(){
        Log.d("MainActivity","load运行了哦");
        FileInputStream in = null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try{
            in=openFileInput("用户账号");
            reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while ((line=reader.readLine())!=null){
                Log.d("MainActivity","line的值为:"+line);
                content.append(line);
                Log.d("MainActivity","try运行了哦");
            };
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Log.d("MainActivity","finally运行了哦");
            if (reader!=null){
                try{
                    reader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    };
    public String loadPassword(){
        Log.d("MainActivity","load运行了哦");
        FileInputStream in = null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try{
            in=openFileInput("用户密码");
            reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while ((line=reader.readLine())!=null){
                Log.d("MainActivity","line的值为:"+line);
                content.append(line);
                Log.d("MainActivity","try运行了哦");
            };
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Log.d("MainActivity","finally运行了哦");
            if (reader!=null){
                try{
                    reader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_first_layout);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        Button finishButton=findViewById(R.id.login_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sqlUserNumber = "1234567890";
                String sqlUserPassword = "1234567890";
                EditText editText1 = (EditText) findViewById(R.id.user_number);
                EditText editText2 = (EditText) findViewById(R.id.user_password);
                String userNumber = editText1.getText().toString();
                String userPassword = editText2.getText().toString();
                Log.d("MainActivity", "用户账号：" + userNumber);
                Log.d("MainActivity", "用户密码:" + userPassword);
                String outUserNumber = loadUserNumber();
                String outPassword = loadPassword();
                if (!TextUtils.isEmpty(outUserNumber) && !TextUtils.isEmpty(outPassword)) {
                    Log.d("MainActivity","判断是不为空");
                    editText1.setText(outUserNumber);
                    editText2.setText(outPassword);
                    editText1.setSelection(outUserNumber.length());
                    editText2.setSelection(outPassword.length());
                    if (!outUserNumber.equals(sqlUserNumber) || !outPassword.equals(sqlUserPassword)) {
                        Toast.makeText(MainActivity.this, "你输入的账号或者密码不正确，请检查后重新输入", Toast.LENGTH_LONG).show();
                    } else {
                        SharedPreferences preferences = getSharedPreferences("用户个人信息", Context.MODE_PRIVATE);
                        if (preferences == null) {
                            Intent intent = new Intent(MainActivity.this, userMassage.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Intent intent = new Intent(MainActivity.this, UserMassageActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
                else {
                    Log.d("MainActivity","判断是为空");
                    if (!userNumber.equals(sqlUserNumber) || !userPassword.equals(sqlUserPassword)) {
                        Toast.makeText(MainActivity.this, "你输入的账号或者密码不正确，请检查后重新输入", Toast.LENGTH_LONG).show();
                    } else {
                        String inputUserNumber = userNumber;
                        String inputPassword = userPassword;
                        saveUserName(inputUserNumber);
                        savePassword(inputPassword);
                        Intent intent = new Intent(MainActivity.this, userMassage.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }

        });
        Button clearButton=findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNumber="用户账号";
                String userPassword="用户密码";
                delFile(userNumber);
                delFile(userPassword);
            }
        });
        Button loginButton=findViewById(R.id.new_user_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AnotherListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        String data= "这是需要传送的数据内容";
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"你点击了这个按钮",Toast.LENGTH_LONG).show();
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button button3 =findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
                finish();
            }
        });
        Button button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.studydemo.ACTION_STRAT");
                intent.addCategory("android.intent.category.ALTERNATIVE");
                startActivity(intent);
            }
        });
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.bilibili.com"));
                startActivity(intent);
            }
        });
        Button button6 =findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        Button button7=findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Fragment_test.class);
                startActivity(intent);
                finish();
            }
        });
        Button button8=findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, BrodcastTest.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.mian,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(MainActivity.this,"add_item",Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this,"remove_tiem",Toast.LENGTH_LONG).show();
                break;
            default:

        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int leimu= requestCode;
        Log.d("MainActivity", String.valueOf(leimu));
        switch (requestCode) {
            case 1:
                if (requestCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_ruturn");
                    Log.d("MainActivity", returnData);
                    break;
                }
            default:
        }
    }


}