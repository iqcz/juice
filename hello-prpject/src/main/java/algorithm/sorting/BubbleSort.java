package algorithm.sorting;

/**
 * 两两比较，邻居好说话
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

    public static void main(String[] args) {
        int[] arr = { 3, 1, 6, 4, 9, 12, 7 };
        int[] afterArr = bubbleSort(arr);

        for (int i = 0; i < afterArr.length; i++) {
            System.out.printf("%d, ", afterArr[i]);
        }

    }
}
