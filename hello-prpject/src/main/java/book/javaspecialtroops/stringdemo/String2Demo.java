package book.javaspecialtroops.stringdemo;

public class String2Demo {

    public static void main(String[] args) {
        String a = "a";
        final String c = "a";

        String b = a + "b";
        String d = c + "b";
        String e = getA() + "b";

        String compare = "ab";
        System.out.println(b == compare);
        System.out.println(d == compare);
        System.out.println(e == compare);
    }

    private static String getA() {
        return "a";
    }
}
