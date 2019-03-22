package exam;

public class Example1241 {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = " world";

        System.out.println(new Str(str1, str2));
        System.out.println(str2);
    }
}

class Str {

    String s1;
    String s2;

    public Str(String str1, String str2) {
        s1 = str1;
        s2 = str2;
        str2 += str1;
    }

    public String toString() {
        return s1 + s2;
    }
}