package dog;

import java.io.*;

public class dog {
    String name;
    int age;
    String eat;
    String color;
    int strong;
    int high;

    public dog(String name) {
        this.name = name;
    }

    public void dogage(int dogage) {
        age = dogage;
    }

    public void dogcolor(String dogcolor) {
        color = dogcolor;
    }

    public void dogeat(String dogeat) {
        eat = dogeat;
    }

    public void dogstrong(int dogstrong) {
        strong = dogstrong;
    }

    public void doghigh(int doghigh) {
        high = doghigh;
    }

    public void printdogimage() {
        System.out.println("名字：" + name);
        System.out.println("年龄：" + age);
        System.out.println("颜色：" + color);
        System.out.println("饮食：" + eat);
        System.out.println("体重：" + strong);
        System.out.println("身高：" + high);
    }
}
