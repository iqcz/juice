package algorithm.sorting;

/**
 * 插入排序
 * 假设第一个元素是有序的，然后从下一个元素开始，和有序的元素比较。
 * 如果要排序的元素小于已排序的元素，继续前移，一直移到大于排序元素的后面。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 类似于打牌摸排时的对扑克牌的操作。
 *
 * @author i324779
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
                // 如果该元素（已排序）大于新元素，将该元素移到下一位置；
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }

            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 另一种插入排序的写法
     * @param array
     * @return
     */
    public static int[] insertionSort2(int[] array) {
        if (array == null) {
            throw new RuntimeException("Array is null");
        }

        if (array.length == 0) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            for (; j > 0 && tmp < array[j - 1]; j--) {
                // 向后移
                array[j] = array[j - 1];
            }
            array[j] = tmp;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 6, 4, 9, 12, 7 };
        int[] afterArr = insertionSort(arr);
        //        int[] afterArr = insertionSort2(arr);

        for (int element : afterArr) {
            System.out.printf("%d, ", element);
        }
    }
}
