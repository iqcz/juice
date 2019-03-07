package book.javaspecialtroops.stringdemo;

/**
 * 常量优化
 */
public class String1Demo {

    public static void main(String[] args) {
        String a = "a" + "b" + 1;
        String b = "ab1";

        // true
        System.out.println(a == b);

    }
}
