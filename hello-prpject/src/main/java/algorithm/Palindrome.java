package algorithm;

import java.util.Stack;

/**
 * 给定一个由多个a字符和b字符组成的字符数组。字符串中又一个特殊的字符X位于串的正中间，
 * 例如ababa...ababXbabab...baaa，如何判定改字符串是否为回文？
 *
 * 使用Stack。
 * @author i324779
 */
public class Palindrome {

    private static boolean isPalindrome(String inputStr) {
        char[] inputChar = inputStr.toCharArray();
        Stack<Character> stack = new Stack<>();

        int i = 0;

        while (inputChar[i] != 'X') {
            stack.push(inputChar[i]);
            i++;
        }
        i++;
        while (i < inputChar.length) {
            if (stack.isEmpty()) {
                return false;
            }
            if (inputChar[i] != stack.pop()) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcXcba"));
    }
}
