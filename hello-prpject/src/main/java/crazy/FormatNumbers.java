package crazy;

import java.text.DecimalFormat;

/**
 * DecimalFormat  完成数字的格式化功能
 * 
 * @author Yanxue Li
 *
 */
public class FormatNumbers {

	public static void main(String[] args) {
        String pattern = "#,###.##";

        DecimalFormat format = new DecimalFormat(pattern);
        String result1 = format.format(1234.56789);

        System.out.println(result1);
	}

}
