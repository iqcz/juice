package algorithm.sorting;

/**
 * 桶排序
 * 《轻松学算法》
 * 适用场景：数据分布比较均匀或者数据跨度范围并不是很大时。
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
                // 进行计数
                buckets[element]++;
                System.out.printf("%d -> %d\n", element, buckets[element]);
            }
        }
    }

    /**
     * 从大到小排序
     */
    public void print() {
        // 倒序输出
        for (int i = buckets.length - 1; i >= 0; i--) {
            // 元素中的值为几，就说明有多少个相同值的元素，就输出几遍
            // 出现了几次就将桶的编号打印几次
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
