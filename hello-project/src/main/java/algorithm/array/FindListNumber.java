package algorithm.array;

/**
 * 给定一个由n-1个整数组成的未排序的数组序列，其元素都是1到n中不同的整数。
 * 找出数组中丢失的数字。
 *
 * @author i324779
 */
public class FindListNumber {
    public static int getLostNumber(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("Invalid parameter");
            return -1;
        }

        int suma = 0;
        int sumb = 0;
        int i;
        for (i = 0; i < arr.length; i++) {
            suma += arr[i];
            sumb += i;
            System.out.printf("suma=%d, sumb=%d\n", suma, sumb);
        }

        // 连续数字累加总和
        sumb = sumb + arr.length + arr.length + 1;

        return sumb - suma;
    }

    // 第二种方式 异或法


    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 4, 7};
        System.out.println(getLostNumber(arr));
    }
}
