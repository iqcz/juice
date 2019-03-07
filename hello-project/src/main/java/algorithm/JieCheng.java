package algorithm;

/**
 * 阶乘
 * 使用递归
 */
public class JieCheng {

    static long fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(fact(12));
    }
}
