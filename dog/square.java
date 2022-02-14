package dog;

public class square {
  public static void main(String[] args) {
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= 3; j++) {
        System.out.print("");
      }
      for (int q = 4; q > i; q--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
