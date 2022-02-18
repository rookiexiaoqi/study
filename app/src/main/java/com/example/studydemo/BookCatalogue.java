package com.example.studydemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class BookCatalogue extends AppCompatActivity {
    private List<Book> bookList = new ArrayList<>();
    private MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_catalogue);
        TextView textViewMain=findViewById(R.id.onetextview);
        textViewMain.setText("书籍目录");
        Button addBookButton=findViewById(R.id.twobutton);
        addBookButton.setText("添加");
        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BookCatalogue.this,SqlDataOperation.class);
                startActivity(intent);
                finish();
            }
        });
        initbooks();//初始化数据
        bookAdapter bookAdapter=new bookAdapter(BookCatalogue.this,R.layout.book_list,bookList);
        ListView listView = findViewById(R.id.book_catalogue);
        listView.setAdapter(bookAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Book book=bookList.get(i);
                Intent intent=new Intent(BookCatalogue.this,BookDetails.class);
                String bookName=book.getBookName().substring(3);
                intent.putExtra("book_name",bookName);
                startActivity(intent);
                finish();
                Log.d("BookCatalogue","传输的内容："+book.getBookName().substring(3));
            }
        });
    }
    private void initbooks(){
        //建立数据库
        myDatabaseHelper=new MyDatabaseHelper(BookCatalogue.this,"BookStore.db",null,2);
        myDatabaseHelper.getWritableDatabase();
        SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();
        Cursor cursor=db.query("Book",null,null,null,null,null,null);
        //遍历cursor对象，并打印数据
        if (cursor.moveToFirst()){
            do {
                String name=cursor.getString(cursor.getColumnIndex("name"));
                String author=cursor.getString(cursor.getColumnIndex("author"));
                int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                double price=cursor.getDouble(cursor.getColumnIndex("price"));
                Log.d("BookCatalogue","book name is "+name);
                Log.d("BookCatalogue","book author is "+author);
                Log.d("BookCatalogue","book pages is "+pages);
                Log.d("BookCatalogue","book price is "+price);
                Book book = new Book("书名：" + name, "作者：" + author);
                bookList.add(book);

            }while (cursor.moveToNext());
        }
        cursor.close();

    }
}
