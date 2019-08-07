package algorithm.bitoperation;

/**
 * 不使用额外变量交换两个变量的值
 *
 * 使用异或运算符
 *
 * @author i324779
 */
public class SwipVariables {
    public static void main(String[] args) {
        int a = 4;
        int b = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }
}
