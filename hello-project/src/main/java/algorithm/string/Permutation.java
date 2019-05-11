package algorithm.string;

/**
 * 求一个字符串的所有排列
 *
 * @author i324779
 */
public class Permutation {

    /**
     * 交换字符位置
     *
     * @param str
     * @param i
     * @param j
     */
    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    /**
     * 对字符串中的字符进行全排列
     *
     * @param str   待排列的字符串
     * @param start 待排列的子字符串的首字母下标
     */
    private static void permutation(char[] str, int start) {
        if (str == null || start < 0) {
            return;
        }

        // 完成全排列后输出当前排列的字符串
        if (start == str.length - 1) {
            System.out.println(str);
        } else {
            for (int i = start; i < str.length; i++) {
                // 交换start与i所在位置的字符
                swap(str, start, i);
                // 固定住第一个字符，对剩余的字符进行全排列
                permutation(str, start + 1);
                swap(str, start, i);
            }
        }
    }

    private static void permutation(String s) {
        char[] str = s.toCharArray();
        permutation(str, 0);
    }

    public static void main(String[] args) {
        String s = "abc";
        permutation(s);
    }
}
