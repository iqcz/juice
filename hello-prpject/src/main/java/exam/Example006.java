package exam;

/**
 * 编写一个截取字符串的函数，输入为一个字符串和字节数， 输出我按字节截取的字符串。但是要保证汉字不被截半个。 例如 输入“人ABC
 * 4”，应该截为“人AB”； 输入“人ABC们DEF 6”，应该输出“人ABC”，而不是“人ABC+们的半个”。
 * 
 * @author i324779
 *
 */
public class Example006 {

	/**
	 * 判断字符 c 是否是中文字符。
	 * 
	 * @param c
	 * @return boolean: true or false.
	 */
	private static boolean isChineseCharacter(char c) {
		String sb = String.valueOf(c);

		return sb.getBytes().length > 1 ? true : false;
	}

	public String truncateString(String str, int length) {
		if (null == str || str.isEmpty() || length == 0) {
			return "";
		}

		char[] charArr = str.toCharArray();

		StringBuilder sb = new StringBuilder("");

		int count = 0; // 记录当前截取字符的长度
		for (char cc : charArr) {

			if (count > length) {
				break;
			}

			if (isChineseCharacter(cc)) {
				// 如果要求截取子串的长度只差一个字符，但是接下来的字符是中午；
				// 截取子字符串中不保存这个中午字符
				if (count + 1 == length) {
					return sb.toString();
				}

				count += 2;
			} else {
				count++;
			}

			sb = sb.append(cc);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Example006 e6 = new Example006();
		String sb = "人ABC们DEF";

		System.out.println(e6.truncateString(sb, 6));
	}

}
