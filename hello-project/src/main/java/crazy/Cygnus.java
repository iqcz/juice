package crazy;

public class Cygnus {

    private static int value = 9;

    private void printValue() {
        int value = 69;

        // 可以使用 this.静态变量 来获取静态变量的值，但不推荐。
        System.out.println(this.value);
        System.out.println(value);
    }

    public static void main(String[] args) {
        new Cygnus().printValue();
    }
}
