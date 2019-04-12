package algorithm.sorting;

/**
 * 归并排序
 * @author i324779
 */
public class MergeSort {

    void mergeSort(int[] a, int[] temp, int left, int right) {
        int mid;
        if (right > left) {
            mid = (left + right) / 2;
            mergeSort(a, temp, left, mid);
            mergeSort(a, temp, mid + 1, right);

            merge(a, temp, left, mid + 1, right);
        }
    }

    private void merge(int[] a, int[] temp, int left, int mid, int right) {
        int leftEnd, size, tempPose;

        leftEnd = mid - 1;
        tempPose = left;
        size = right - left + 1;

        while (left <= leftEnd && mid <= right) {
            if (a[left] <= a[mid]) {
                temp[tempPose] = a[left];
                tempPose += 1;
                left += 1;
            } else {
                temp[tempPose] = a[mid];
                tempPose += 1;
                mid += 1;
            }
        }

        while (left <= leftEnd) {
            temp[tempPose] = a[left];
            left += 1;
            tempPose += 1;
        }

        while (mid <= right) {
            temp[tempPose] = a[mid];
            mid += 1;
            tempPose += 1;
        }

        for (int i = 0; i < size; i++) {
            a[right] = temp[right];
            right -= 1;
        }
    }

    public static void main(String[] args) {
        int[] data = { 4, 1, 9, 3, 2, 19, 3, 8, 7, 0 };
        int[] temp = new int[data.length];
        MergeSort ms = new MergeSort();

        ms.mergeSort(data, temp, 0, data.length - 1);

        for (int i : temp) {
            System.out.printf("%d, ", i);
        }
    }
}
