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



    public static void main(String[] args) {
        int[] data = {2, 4, 6, 8, 10, 12, 16, 18, 20};
        
        System.out.println(standardBinarySearch(data, 18));
    }
}
