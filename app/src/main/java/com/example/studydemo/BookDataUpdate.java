package com.example.studydemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class BookDataUpdate extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_data_update);
        TextView textViewMain = findViewById(R.id.onetextview);
        textViewMain.setText("书籍信息修改");
        EditText editTextName = findViewById(R.id.date_update_name);
        EditText editTextAuthor = findViewById(R.id.date_update_author);
        EditText editTextPages = findViewById(R.id.date_update_pages);
        EditText editTextPrice = findViewById(R.id.date_update_price);
        Button updateButton = findViewById(R.id.data_update_button);
        Intent intent = getIntent();
        String bookName = intent.getStringExtra("book_name");
        Log.d("BookDataUpdate", "传输接收到的内容：" + bookName);
        Button ReturnPrevious = findViewById(R.id.onebutton);
        ReturnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookDataUpdate.this, BookDetails.class);
                intent.putExtra("book_name", bookName);
                startActivity(intent);
                finish();
            }
        });
        Button phoneCallButton = findViewById(R.id.twobutton);
        phoneCallButton.setText("咨询");
        phoneCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(BookDataUpdate.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(BookDataUpdate.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    call();
                }
            }
        });
        MyDatabaseHelper myDatabaseHelper;
        myDatabaseHelper = new MyDatabaseHelper(BookDataUpdate.this, "BookStore.db", null, 2);
        myDatabaseHelper.getWritableDatabase();
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        Cursor cursor = db.query("Book", null, "name=?", new String[]{bookName}, null, null, null);
        //遍历cursor对象，并打印数据
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                Log.d("BookDataUpdate", "book name is " + name);
                Log.d("BookDataUpdate", "book author is " + author);
                Log.d("BookDataUpdate", "book pages is " + pages);
                Log.d("BookDataUpdate", "book price is " + price);
                Log.d("BookDataUpdate", "book id is " + id);
                SpannableString updateName = new SpannableString(name);
                SpannableString updateAuthor = new SpannableString(author);
                SpannableString updatePages = new SpannableString(Integer.toString(pages));
                SpannableString updatePrice = new SpannableString(Double.toString(price));
                editTextName.setHint(updateName);
                editTextAuthor.setHint(updateAuthor);
                editTextPages.setHint(updatePages);
                editTextPrice.setHint(updatePrice);
                updateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String newId = Integer.toString(id);
                        Log.d("BookDataUpdate", "我运行了,newId的值为：" + newId);
                        String newName = editTextName.getText().toString();
                        String newAuthor = editTextAuthor.getText().toString();
                        String newPages = editTextPages.getText().toString();
                        String newPrice = editTextPrice.getText().toString();
                        Log.d("BookDataUpdate", "更新内容：" + newName + newAuthor + newPages + newPrice);
                        if (!TextUtils.isEmpty(newName)) {
                            db.execSQL("update Book set name=? where id= ?", new String[]{newName, newId});
                            Log.d("BookDataUpdate", newName + "运行了");
                        }
                        if (!TextUtils.isEmpty(newAuthor)) {
                            db.execSQL("update Book set author=? where id= ?", new String[]{newAuthor, newId});
                            Log.d("BookDataUpdate", newAuthor + "运行了");
                        }
                        if (!TextUtils.isEmpty(newPages)) {
                            db.execSQL("update Book set pages=? where id= ?", new String[]{newPages, newId});
                            Log.d("BookDataUpdate", newPages + "运行了");
                        }
                        if (!TextUtils.isEmpty(newPrice)) {
                            db.execSQL("update Book set price=? where id= ?", new String[]{newPrice, newId});
                            Log.d("BookDataUpdate", newPrice + "运行了");
                        }
                        if (TextUtils.isEmpty(newName)) {
                            newName = name;
                            Intent intent = new Intent(BookDataUpdate.this, BookDetails.class);
                            intent.putExtra("book_name", newName);
                            startActivity(intent);
                            finish();

                        } else {
                            Intent intent = new Intent(BookDataUpdate.this, BookDetails.class);
                            intent.putExtra("book_name", newName);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

            } while (cursor.moveToNext());
        }
        cursor.close();

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    call();
                }else {
                    Toast.makeText(this,"you denied the permission",Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }
    private void call(){
        try {
            Log.d("BookDataUpdate","call()运行了");
            Intent intent= new Intent(Intent.ACTION_CALL);
            String phoneNumber="18881146779";
            intent.setData(Uri.parse("tel:"+phoneNumber));
            startActivity(intent);
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}