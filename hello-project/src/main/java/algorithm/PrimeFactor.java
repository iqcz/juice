package algorithm;

import java.util.Scanner;

/**
 * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 *
 * @author i324779
 */
public class PrimeFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = 2;
        while (n >= k) {
            if (n == k) {
                System.out.println(k);
                break;
            } else if (n % k == 0) {
                System.out.println(k);
                n = n / k;
            } else {
                k++;
            }
        }
    }
}
