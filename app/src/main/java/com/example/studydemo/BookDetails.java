package com.example.studydemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        Intent intent=getIntent();
        String bookName=intent.getStringExtra("book_name");
        Log.d("BookDetails","获得的内容："+bookName);
        TextView textViewMain=findViewById(R.id.onetextview);
        TextView textViewName=findViewById(R.id.details_book_name);
        TextView textViewAuthor=findViewById(R.id.details_book_author);
        TextView textViewPages=findViewById(R.id.details_book_pages);
        TextView textViewPrice=findViewById(R.id.details_book_price);
        textViewMain.setText("书籍信息");
        Button ReturnPrevious=findViewById(R.id.onebutton);
        ReturnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BookDetails.this,BookCatalogue.class);
                startActivity(intent);
                finish();
            }
        });
        MyDatabaseHelper myDatabaseHelper;
        myDatabaseHelper=new MyDatabaseHelper(BookDetails.this,"BookStore.db",null,2);
        myDatabaseHelper.getWritableDatabase();
        SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();
        Cursor cursor= db.query("Book",null,"name=?",new String[]{bookName}, null,null,null);
        //遍历cursor对象，并打印数据
        if (cursor.moveToFirst()){
            do {
                String name=cursor.getString(cursor.getColumnIndex("name"));
                String author=cursor.getString(cursor.getColumnIndex("author"));
                int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                double price=cursor.getDouble(cursor.getColumnIndex("price"));
                Log.d("BookDetails","book name is "+name);
                Log.d("BookDetails","book author is "+author);
                Log.d("BookDetails","book pages is "+pages);
                Log.d("BookDetails","book price is "+price);
                textViewName.setText(name);
                textViewAuthor.setText(author);
                textViewPages.setText(Integer.toString(pages));
                textViewPrice.setText(Double.toString(price));
            }while (cursor.moveToNext());
        }
        cursor.close();
        Button updateButton=findViewById(R.id.update_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*switch (view.getId()){
                    case R.id.update_button:
                        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        @SuppressLint("WrongConstant") Notification notification=new Notification.Builder(BookDetails.this)
                                .setContentText("请谨慎修改书本信息")
                                .setWhen(System.currentTimeMillis())
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher ))
                                .setPriority(NotificationCompat.PRIORITY_MAX)
                                .build();
                        notificationManager.notify(1,notification);
                        break;
                    default:
                        break;
                }*/
                Log.d("BookDetails","你点击了修改数据");
                Intent intent=new Intent(BookDetails.this,BookDataUpdate.class);
                intent.putExtra("book_name",bookName);
                startActivity(intent);
                finish();
            }
        });
        Button deleteButton=findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BookDetails","你点击了删除");
                db.execSQL("delete from book where name=?",new String[]{bookName});
                Intent intent=new Intent(BookDetails.this,BookCatalogue.class);
                startActivity(intent);
                finish();
            }
        });
        Button moreOursButton =findViewById(R.id.more_ours_button);
        moreOursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookDetails.this,MoreOurs.class);
                startActivity(intent);
            }
        });
    }
}