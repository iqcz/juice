package algorithm.sorting;

/**
 * 桶排序
 * 《轻松学算法》
 * @author i324779
 */
public class BucketSort {

    private int[] buckets;
    private int[] array;

    public BucketSort(int range, int[] array) {
        this.buckets = new int[range];
        this.array = array;
    }

    public void sort() {
        if (array != null && array.length > 1) {
            for (int element : array) {
                buckets[element]++;
            }
        }
    }

    public void print() {
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = 0; j < buckets[i]; j++) {
                System.out.printf("%d, ", i);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 5, 9, 1, 9, 5, 3, 7, 6, 1 };
        BucketSort bucketSort = new BucketSort(11, array);
        bucketSort.sort();
        bucketSort.print();
    }

}
