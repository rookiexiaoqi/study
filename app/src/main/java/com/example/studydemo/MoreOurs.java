package com.example.studydemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;

public class MoreOurs extends AppCompatActivity {
    TextView responseText;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_ours);
        /*
        //最简单的使用webView访问网址
        WebView webView=findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.bilibili.com");*/
        //使用httpURLconnection实现访问请求
        Button sendRequest=findViewById(R.id.send_request);
        responseText=findViewById(R.id.response_text);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()== R.id.send_request){
                    sendRequestWithHttpURLConnection();
                }
            }
        });
    }
    private void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                HttpURLConnection connection=null;
                BufferedReader reader=null;
                try {
                    URL url=new URL("http://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in=connection.getInputStream();
                    //下面对获取到的输入流进行读取
                    reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder response=new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        response.append(line);
                    }
                    showResponse(response.toString());

                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if (reader!=null){
                        try {
                            reader.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }if (connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();

    }
    private void showResponse(final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }

}