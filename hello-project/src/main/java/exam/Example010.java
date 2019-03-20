package exam;

public class Example010 {

    public void someOuterMethod() {
        new Inner(); // put here when Inner is not a static inner class.
    }

    //    public class Inner {}

    public static class Inner {
    }

    public static void main(String[] args) {
        Example010 e = new Example010();
        e.someOuterMethod();

        // when Inner class is static, below statements are OK.
        new Example010.Inner();
        new Inner();

    }

}
