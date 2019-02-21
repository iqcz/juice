package algorithm.searching;

/**
 * 三路比较方法的基本二分法查找
 */
public class BinarySearchVersion1 {

    public static int standardBinarySearch(int[] data, int key) {
        // not found
        int location = -1;
        if (data.length == 0) {
            return -1;
        }

        int low = 0;
        int high = data.length - 1;
        int middle;

        while (low <= high) {
            middle = (low + high) / 2;
            if (data[middle] < key) {
                low = middle + 1;
            } else if (data[middle] > key) {
                high = middle - 1;
            } else {
                return middle;
            }
        }

        return location;
    }

    /**
     * 使用递归进行二分法查找
     *
     * @param a 待查找的数组
     * @param low 查找开始位置
     * @param high 查找结束位置
     * @param data 要查找的数据
     * @return 查找元素的下标索引
     */
    static int binarySearchRecursive(int[] a, int low, int high, int data) {
        // 避免溢出
        int mid = low + (high - low) / 2;
        if (a[mid] == data) {
            return mid;
        } else if (a[mid] < data) {
            return binarySearchRecursive(a, mid + 1, high, data);
        } else {
            return binarySearchRecursive(a, low, mid - 1, data);
        }
    }

    public static void main(String[] args) {
        int[] data = { 2, 4, 6, 8, 10, 12, 16, 18, 20 };

        System.out.println(standardBinarySearch(data, 18));
        System.out.println(binarySearchRecursive(data, 0, data.length, 18));
    }
}
