package algorithm.datastructors;

/**
 * 和为指定值的两个数
 * 思路
 * <p>
 * 1 先排序，后加
 * <p>
 * 2 用哈希表，key为数的值，value为位置。这样，hashMap.get(sum-arr[i])，O(1)定位
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 5, 4, 1, 2, 3, 6, 9};
        findByHash(arr, 10);
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        find(arr2, 10);
    }

    public static void find(int[] arr, int sum) {
        //arr 这里arr是排好序的了
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            if (arr[begin] + arr[end] == sum) {
                System.out.println(String.format(("[%d,%d]"), arr[begin], arr[end]));
                begin++;
            } else if (arr[begin] + arr[end] > 0) {
                end--;
            } else {
                begin++;
            }
        }

    }

    public static void findByHash(int[] arr, int sum) {
        Hashtable<Integer, Integer> hashMap = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int index = hashMap.get(sum - arr[i]);
            if (index != -1 && index > i) {
                System.out.println(String.format(("[%d,%d]"), arr[i], arr[index]));
            }
        }
    }
}