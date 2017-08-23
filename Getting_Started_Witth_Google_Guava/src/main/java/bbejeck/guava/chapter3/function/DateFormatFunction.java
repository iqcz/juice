package bbejeck.guava.chapter3.function;

import com.google.common.base.Function;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Bill Bejeck
 * Date: 3/30/13
 * Time: 10:14 PM
 * 
 * 此类只是做demo用，这样简单的功能没必要使用函数式写法，
 * 增加了代码的阅读难度
 */
public class DateFormatFunction implements Function<Date, String> {

	private String dateFormat;

	public DateFormatFunction(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Override
	public String apply(Date input) {
		return new SimpleDateFormat(dateFormat).format(input);
	}
}
