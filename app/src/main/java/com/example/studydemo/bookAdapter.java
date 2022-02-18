package com.example.studydemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Class:weekAdapter
 *
 * @author: rookiexiaoqi
 * Description:
 * @Date: 2022/2/11
 * 四川农信 Rem is the best in the world
 */
public class bookAdapter extends ArrayAdapter<Book> {
    private int resourceid;
    public bookAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Book> objects) {
        super(context, textViewResourceId,objects);
        resourceid=textViewResourceId;
    }

    @NonNull


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book book=getItem(position);
        View view;

        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceid,parent,false);
        }else{
            view=convertView;

        }
        TextView textViewName=view.findViewById(R.id.book_name);
        TextView textViewContent=view.findViewById(R.id.book_author);
        textViewName.setText(book.getBookName());
        textViewContent.setText(book.getBookAuthor());
        return view;
    }
}
