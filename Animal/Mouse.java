package Animal;

public class Mouse extends Animal {

  public Mouse(String name, int id) {
    super(name, id);
  }

  public void movementMode() {
    System.out.println(name + "运动方式为跑");
  }

  // public void whatEat() {
  // System.out.println(name + "吃大米");
  // }

  public void liveWay() {
    System.out.println(name + "夜间生活");
  }

  public static void main(String[] args) {
    Mouse m1 = new Mouse("老鼠", 2);
    // Animal m2 = new Animal("老鼠", 2);
    System.out.println(m1.id + "." + m1.name);
    m1.movementMode();
    m1.whatEat();
    m1.liveWay();
    // m2.whatEat();
  }
}
