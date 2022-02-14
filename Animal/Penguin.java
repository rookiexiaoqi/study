package Animal;

public class Penguin extends Animal {

  public Penguin(String name, int id) {
    super(name, id);
  }

  public void eat() {
    System.out.println(name + "正在吃");
  }

  public void movementMode() {
    System.out.println(name + "运动方式为走");
  }

  public static void main(String[] args) {
    Penguin p = new Penguin("企鹅", 1);
    System.out.println(p.id + "." + p.name);
    p.eat();
    p.movementMode();
  }

}
