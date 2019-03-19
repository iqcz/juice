package exam;

/**
 * recursion
 * 递归
 * @author TurtusLi
 *
 */
public class Example002 {

    public static long fac(int n) {
        if (n > 1) {
            return (n * fac(n - 1));
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(fac(4));
    }

}
