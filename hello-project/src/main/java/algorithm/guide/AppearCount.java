package algorithm.guide;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;

/**
 * 判断数组中是否有重复元素。
 *
 * @author i324779
 */
public class AppearCount {

    public static void main(String[] args) {
        char[] data = { 1, 2, 3, 4, 5, 2};
        System.out.println(isUnique(data));

        /*
        String ids = "1,2,3,4,5,66,";
        List<Integer> all = Splitter.on(',').omitEmptyStrings().splitToList(ids).stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(all);
         */
    }

    public static boolean isUnique(char[] data) {
        if (Objects.isNull(data)) {
            return false;
        }

        // 注意越界问题
        boolean[] map = new boolean[10];
        for (char element : data) {
            if (map[element]) {
                return false;
            }
            map[element] = true;
        }
        return true;
    }
}
