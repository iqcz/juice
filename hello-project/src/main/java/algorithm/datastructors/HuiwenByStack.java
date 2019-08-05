package algorithm.datastructors;

/**
 * 使用栈结构来判断一个字符串是否是回文。
 *
 * @author i324779
 */
public class HuiwenByStack {

    public static void main(String[] args) {
        // 待判断的 char 数组
        char[] a = {'a', 'b', 'b', 'a'};
        char[] s = new char[100];

        // 指向栈顶变量
        int top = 0;

        int len = a.length;

        // 字符串中点
        int mid = len / 2;


        // 将 mid 前的字符依次入栈
        for (int i = 0; i < mid; i++) {
            s[++top] = a[i];
        }

        int next;
        // 判断字符串的长度是奇数还是偶数，并找出需要进行字符串匹配的起始下标
        if (len % 2 == 0) {
            next = mid;
        } else {
            next = mid + 1;
        }

        // 开始匹配
        for (int i = next; i <= len - 1; i++) {
            if (a[i] != s[top]) {
                break;
            }
            top--;
        }

        // 如果 top 为0，则说明栈内所有的字符都被一一匹配过了
        if (top == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
