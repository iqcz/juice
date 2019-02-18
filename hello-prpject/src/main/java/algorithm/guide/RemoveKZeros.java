package algorithm.guide;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * 给定一个字符串和一个整数k，去掉字符串中指定连续个数k的0。
 * @author i324779
 */
public class RemoveKZeros {

    public static String removeKZeros(String str, int k) {
        if (isNullOrEmpty(str) || k < 1) {
            return str;
        }

        char[] chars = str.toCharArray();
        // 连续出现0的次数
        int count = 0;
        // 连续出现0的开始位置
        int start = -1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        // todo bug!
                        chars[start++] = 0;
                    }
                    count = 0;
                    start = -1;
                }
            }
        }
        if (count == k) {
            while (count-- != 0) {
                chars[start++] = 0;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(removeKZeros("he00llo", 2));
    }

}
