package algorithm.sorting;

/**
 * 两两比较，邻居好说话
 *
 * 改进方案：1.增加标识位；2.一次冒两个泡
 * @author i324779
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

        // 外层循环只趟数
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] bubbleSort1(int[] arr) {

        int temp;
        //表示趟数，一共arr.length-1次。
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 6, 4, 9, 12, 7 };
        int[] afterArr = bubbleSort1(arr);

        for (int i1 : afterArr) {
            System.out.printf("%d, ", i1);
        }
    }
}
