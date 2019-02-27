package exam;

/**
 * 回文数字
 *
 * @author i324779
 */
public class CircleNumber {

    public static void main(String[] args) {
        for (int i = 10; i < 10000; i++) {
            if (isCircleNumber(i)) {
                System.out.println(i + " 是回文数。");
            }
        }
    }

    private static boolean isCircleNumber(int num) {
        // 保存原有的值
        int oldValue = num;
        // 反过来的值
        int invertValue = 0;
        // 循环number的每一位数值
        while (num > 0) {
            // 得到一位数字
            invertValue = invertValue * 10 + num % 10;
            // num 减少一位
            num /= 10;
        }

        // 判断反值是否与原值相等
        return invertValue == oldValue;
    }
}
