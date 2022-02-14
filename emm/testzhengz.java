package emm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testzhengz {
  public void testzhengzhi(String str) {
    String pattern = "((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d)|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d))$)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(str);
    System.out.println(m.matches());
    if (m.matches() == true) {
      System.out.println("输入的电话号码正确");
    }
  }

  public static void main(String args[]) {
    testzhengz t = new testzhengz();
    String s = "19380504129";
    t.testzhengzhi(s);

  }

}
