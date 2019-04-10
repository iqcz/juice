package algorithm.string;

/**
 * 判断字符数组里的字符元素都只出现过一次。
 *
 * 时间复杂度：O(n).
 * @author i324779
 */
public class OccurOnlyOneTimeChar {

    public static boolean isUnique(char[] chas) {
        if (chas == null) {
            return false;
        }

        boolean[] map = new boolean[256];
        for (char cha : chas) {
            if (map[cha]) {
                return false;
            }
            map[cha] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        char[] chas = { 1, 3, 5, 5 };

        System.out.println(isUnique(chas));
    }
}
