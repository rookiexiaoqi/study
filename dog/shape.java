package dog;

class Person {
  private String name; // 姓名属性
  private int age; // 年龄属性
  static int count; // 静态变量，用来统计对象数（类中默认初始化）

  public Person() {
    System.out.println("调用无参构造");
    count++;
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    System.out.println("调用有参构造");
    count++;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void eat() {
    System.out.println(name + "吃东西");
  }
}