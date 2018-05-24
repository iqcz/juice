package exam;

/**
 * 回文数字
 * 
 * @author TurtusLi
 *
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
		int oldValue = num; // 保存原有的值
		int temp = 0; // 反过来的值
		while (num > 0) { // 循环number的每一位数值
			temp = temp * 10 + num % 10; // 得到一位数字
			num /= 10; // num 减少一位
		}

		return temp == oldValue; // 判断反值是否与原值相等
	}

}
