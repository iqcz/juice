package algorithm.array;

import java.util.HashMap;

/**
 * 找出在数组中唯一的重复元素
 *
 * @author i324779
 */
public class FindDup {

    /**
     * hash
     * @param array
     * @return
     */
    public static int findDup(int[] array) {
        if (array == null) {
            return -1;
        }

        int len = array.length;

        HashMap<Integer, Integer> map = new HashMap<>(len);
        int i;
        for (i = 0; i < len; i++) {
            map.put(i, 0);
        }

        for (i = 0; i < len; i++) {
            if (map.get(array[i]) == 0) {
                map.put(array[i], array[i]);
            } else {
                return array[i];
            }
        }

        return -1;
    }

    // 2，累加求和法， 数据过多，会越界

    // 3， 异或法

    // 4. 数据映射法

    // 5, 环形相遇法


    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2, 5, 0, 3};
        System.out.println(findDup(array));
    }
}
