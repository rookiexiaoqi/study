package dog;

abstract class E {
  public abstract void show();
}

class F extends E {
  public void show() {
    System.out.print("test all FFFF \n");
  }
}

class G extends E {
  public void show() {
    System.out.print("test all GGGG \n");
  }
}

public class abs {
  public static void main(String[] args) throws InterruptedException {
    E p = new F();
    p.show();
    E q = new G();
    q.show();
  }
}