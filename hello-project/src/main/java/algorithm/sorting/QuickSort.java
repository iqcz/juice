package algorithm.sorting;

import java.util.Objects;

/**
 * @author i324779
 */
public class QuickSort {

    public static int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }

        int smallIndex = partition(array, start, end);

        if (smallIndex > start) {
            quickSort(array, start, smallIndex - 1);
        }

        if (smallIndex < end) {
            quickSort(array, smallIndex + 1, end);
        }

        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void main(String[] args) {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (10 + 1));
        }
        int[] afterArr = quickSort(arr, 0, arr.length - 1);

        for (int element : Objects.requireNonNull(afterArr)) {
            System.out.printf("%d ", element);
        }
    }
}
