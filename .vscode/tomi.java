public class tomi {
    int tomiage;
    String tomieat;

    public tomi(String name) {
        System.out.println("小狗的名字是" + name);
    }

    public void setAge(int age) {
        tomiage = age;
    }

    public int getAge() {
        System.out.println("小狗的年龄是" + tomiage);
        return tomiage;
    }

    public void setEat(String eat) {
        tomieat = eat;
    }

    public int getEat() {
        System.out.println("小狗的饮食是" + tomieat);
        return 0;
    }

    public static void main(String[] args) {
        tomi tomitomi = new tomi("tomi");
        tomi tomitomi1 = new tomi("tomi1");
        tomitomi.setAge(5);
        tomitomi.getAge();
        tomitomi.setEat("骨头");
        tomitomi.getEat();
        tomitomi1.setAge(1);
        tomitomi1.getAge();
        tomitomi1.setEat("米饭");
        tomitomi1.getEat();
    }

}
