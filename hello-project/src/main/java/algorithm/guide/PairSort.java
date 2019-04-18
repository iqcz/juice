package algorithm.guide;


/**
 * 给定一个数组，如何检查该数组是否的成对有序的？
 * 如果数组中的连续的数字对是有序的（非递减），
 * 则认为该数组是成对有序的。
 *
 * @author i324779
 */
public class PairSort {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 5, 9, 10, 18, 15};
        System.out.println(isPairWithSorted(arr, arr.length));

    }

    public static boolean isPairWithSorted(int[] a, int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        for (int i = 0; i < n - 1; i += 2) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
