package dog;

public class Change {
  public static void main(String[] args) {
    int grade = 85;
    System.out.println("你的成绩是：" + grade);
    switch (grade) {
      case 0:
        if (grade <= 100 || grade >= 90) {
          System.out.println("A");
        }
        break;
      case 1:
        if (grade < 90 || grade >= 80) {
          System.out.println("B");
        }
        break;
      case 2:
        if (grade < 80 || grade >= 70) {
          System.out.println("C");
        }
        break;
      case 3:
        if (grade < 70 || grade >= 60) {
          System.out.println("D");
        }
        break;
      default:
        System.out.println("F");
        break;
    }
    System.out.println("你的成绩等级是" + grade);
  }
}
