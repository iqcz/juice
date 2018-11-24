package algorithm.guide;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * 判断两个字符串是不是变形词
 */
public class Anagram {

    public static void main(String[] args) {
        String str1 = "真漂亮";
        String str2 = "亮漂真";

        System.out.println(isDeformation(str1, str2));
    }

    public static boolean isDeformation(String str1, String str2) {
        if (isNullOrEmpty(str1) || isNullOrEmpty(str2)) {
            return false;
        }

        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();

        int[] map = new int[65535];

        for (char aChas1 : chas1) {
            map[aChas1]++;
        }
        for (char aChas2 : chas2) {
            if (map[aChas2]-- == 0) {
                return false;
            }
        }

        return true;
    }
}
