package algorithm;

/**
 * 判断是否是回文字符串，其特点是正读反读都是一样的。
 * 解决方式：对半判断。计算出中轴位置。
 * 《轻松学算法》P288
 * @author i324779
 */
public class PalindromeString {

    /**
     * 判断回文字符串
     * @param str 要判断的字符串
     * @return 是否是回文字符串
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int strLength = str.length();
        int middle = (strLength - 1) / 2;

        for (int i = 0; i <= middle; i++) {
            if (str.charAt(i) != str.charAt(strLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdcba"));
        System.out.println(isPalindrome("abc"));
        System.out.println(isPalindrome("abba"));
    }
}
