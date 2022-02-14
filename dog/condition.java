package dog;

public class condition {
  public static void main(String[] args) {
    int va = 50;
    int money = 6;
    if (money > va) {
      System.out.println("你所支付的钱不够，请重新支付");
    } else {
      int a = 0;
      a = va - money;
      System.out.println("找零" + a + "元");
    }
  }
}
