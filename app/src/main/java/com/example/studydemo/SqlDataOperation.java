package com.example.studydemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SqlDataOperation extends AppCompatActivity {
    private MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_data_operation);
        TextView textView=findViewById(R.id.onetextview);
        textView.setText("新增书本信息");
        /*SQLite数据库方式存储数据*/
        /*创建数据库*/
        myDatabaseHelper=new MyDatabaseHelper(SqlDataOperation.this,"BookStore.db",null,2);
        myDatabaseHelper.getWritableDatabase();
        /*使用SQL操作数据库的方法*/
        SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();
        Button addButton=findViewById(R.id.add_sql_data);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText1=findViewById(R.id.add_sql_book_name);
                EditText editText2=findViewById(R.id.add_sql_book_author);
                EditText editText3=findViewById(R.id.add_sql_book_pages);
                EditText editText4=findViewById(R.id.add_sql_book_prices);
                String bookName=editText1.getText().toString();
                String bookAuthor=editText2.getText().toString();
                String bookPages=editText3.getText().toString();
                String bookPrices=editText4.getText().toString();
                Log.d("SqlDataOperation","你点击了添加数据");
                //添加数据的方法
                ContentValues values=new ContentValues();
                //向数据库里面填入第一条数据
                values.put("name","如果有真爱，那么一定是蓝色——蕾姆天下第一");
                values.put("author","rookiexiaoqi");
                values.put("pages", 520);
                values.put("price",5201314);
                db.insert("Book",null,values);
                values.clear();
                //向数据库里面填入第二条数据
                values.put("name","七七永远是我的亲女儿");
                values.put("author","rookiexiaoqi");
                values.put("pages", 521);
                values.put("price",5211314);
                db.insert("Book",null,values);
                values.clear();
                //另一种方法
                db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)",
                        new String[]{"论蕾姆为什么天下第一","rookiexiaoqi","121","56.22"});
                db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)",
                        new String[]{bookName,bookAuthor,bookPages,bookPrices});
            }
        });
        Button upDataButton =findViewById(R.id.updata_sql_data);
        upDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //更新数据的方法
            public void onClick(View view) {
                Log.d("SqlDataOperation","你点击了修改数据");
                ContentValues values=new ContentValues();
                values.put("name","蕾姆天下第一");
                db.update("Book",values,"name=?",new String[]{"如果有真爱，那么一定是蓝色——蕾姆天下第一"});
                //另一种写法
                db.execSQL("update Book set price=? where name= ?",new String[]{"12.23","论蕾姆为什么天下第一"});
            }
        });
        Button deleteButton=findViewById(R.id.delete_sql_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //删除数据的方法
            public void onClick(View view) {
                Log.d("SqlDataOperation","你点击了删除数据");
                db.delete("Book","pages > ?",new String[]{"600"});
                //另一种写法
                db.execSQL("delete from book where name=?",new String[]{"论蕾姆为什么天下第一"});
            }
        });
        Button queryButton=findViewById(R.id.query_sql_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //查询数据的方法
            public void onClick(View view) {
                Log.d("SqlDataOperation","你点击了查询数据");
                Cursor cursor=db.query("Book",null,null,null,null,null,null);
                //遍历cursor对象，并打印数据
                if (cursor.moveToFirst()){
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("SqlDataOperation","book name is "+name);
                        Log.d("SqlDataOperation","book author is "+author);
                        Log.d("SqlDataOperation","book pages is "+pages);
                        Log.d("SqlDataOperation","book price is "+price);
                    }while (cursor.moveToNext());
                }
                cursor.close();
                //另一种写法
                db.rawQuery("select * from book",null);
            }
        });
    }
}