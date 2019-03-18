package algorithm.string;

/** 反转字符串
 * @author i324779
 */
public class ReverseString {

    public static String reverseString(String string) {
        if (string == null || string.length() == 0) {
            throw new RuntimeException("字符串为null或为空。");
        }
        char[] chars = string.toCharArray();

        char[] reverseChars = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseChars[chars.length - 1 - i] = chars[i];
        }

        return new String(reverseChars);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcdef"));
    }
}