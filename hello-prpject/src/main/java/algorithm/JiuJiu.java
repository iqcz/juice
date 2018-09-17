package algorithm;

/**
 * 使用一层循环打印九九乘法表
 * @author User
 *
 */
public class JiuJiu {

    public static void main(String[] args) {
        for (int i = 1, j = 1; j <= 9; i++) {
            System.out.print(i + " * " + j + " = " + i * j + "    ");
            if (i == j) {
                i = 0;
                j++;
                System.out.println();
            }
        }
    }
}
