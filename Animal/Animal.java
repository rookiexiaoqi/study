package Animal;

public class Animal {
  String name;
  int id;

  public Animal(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public void eat() {
  }

  public void movementMode() {
  }

  public void whatEat() {
    System.out.println(name + "不吃大米");
  }

}
