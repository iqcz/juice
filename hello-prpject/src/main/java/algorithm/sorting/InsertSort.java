package algorithm.sorting;

/**
 * 插入排序
 */
public class InsertSort {

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }

            array[preIndex + 1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 6, 4, 9, 12, 7 };
        int[] afterArr = insertionSort(arr);

        for (int i = 0; i < afterArr.length; i++) {
            System.out.println(afterArr[i]);
        }
    }
}
