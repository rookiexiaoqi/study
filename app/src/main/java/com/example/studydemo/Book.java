package com.example.studydemo;

/**
 * Class:Book
 *
 * @author: rookiexiaoqi
 * Description:
 * @Date: 2022/2/16
 * 四川农信 Rem is the best in the world
 */
public class Book {
    private String bookName;
    private String bookAuthor;
    public Book(String bookName,String bookAuthor){
        this.bookName=bookName;
        this.bookAuthor=bookAuthor;
    }
    public String getBookName(){
        return bookName;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
}
