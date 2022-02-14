package dog;

import java.io.*;

import javax.xml.crypto.dsig.dom.DOMSignContext;

public class dogtest {
    public static void main(String[] args) {
        dog dogone = new dog("黑毛");
        dog dogtwo = new dog("小白");
        dog dogthree = new dog("粉白");
        dogone.dogage(1);
        dogone.dogcolor("黑色");
        dogone.dogeat("骨头");
        dogone.dogstrong(12);
        dogone.doghigh(20);
        dogone.printdogimage();
        dogtwo.dogage(2);
        dogtwo.dogcolor("白色");
        dogtwo.dogeat("肉");
        dogtwo.dogstrong(15);
        dogtwo.doghigh(30);
        dogtwo.printdogimage();
        dogthree.dogage(4);
        dogthree.dogcolor("粉色");
        dogthree.dogeat("鱼");
        dogthree.dogstrong(5);
        dogthree.doghigh(13);
        dogthree.printdogimage();

    }
}
