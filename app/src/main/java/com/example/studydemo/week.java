package com.example.studydemo;

/**
 * Class:week
 *
 * @author: rookiexiaoqi
 * Description:
 * @Date: 2022/2/11
 * 四川农信 Rem is the best in the world
 */
public class week {
    private int weekName;
    private int weekContext;
    public week(int weekName,int weekContext){
        this.weekName=weekName;
        this.weekContext=weekContext;
    }
    public int getWeekName(){
      return weekName;
    };
    public  int getWeekContext(){
        return weekContext;
    };
}
