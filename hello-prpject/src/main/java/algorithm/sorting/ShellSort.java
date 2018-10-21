package algorithm.sorting;

public class ShellSort {

    public static int[] shellSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int len = array.length / 2;
        int temp;
        int gap = len / 2;

        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 6, 4, 9, 12, 7 };
        int[] afterArr = shellSort(arr);

        for (int element : afterArr) {
            System.out.println(element);
        }
    }
}
