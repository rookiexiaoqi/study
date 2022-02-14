package dog;

public class While {
  public static void main(String[] args) {
    // 1.do...whlie循环
    // int a = 20;
    // do {
    // System.out.println("a的值为：" + a);
    // a--;
    // } while (a >= 1);
    // }
    // 2.while循环
    // int a = 0;
    // while (a < 20) {
    // System.out.println("a的值为：" + a);
    // a++;
    //
    // 3.for 循环
    int a = 100;
    int num = 0;
    for (int i = 0; i < a; i++) {
      num = num + i;
    }
    System.out.println(num);
  }
}
