package bbejeck.guava.chapter2.splitter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

/**
 * User: Bill Bejeck Date: 3/17/13 Time: 9:39 PM
 */
public class SplitterTest {

	/**
	 * 把一个字符串根据指定分隔符，最后形成Map。
	 */
	@Test
	public void testSplitter() {
		String startSring = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
		Map<String, String> testMap = Maps.newLinkedHashMap();
		testMap.put("Washington D.C", "Redskins");
		testMap.put("New York City", "Giants");
		testMap.put("Philadelphia", "Eagles");
		testMap.put("Dallas", "Cowboys");

		// key part
		Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
		Map<String, String> splitMap = mapSplitter.split(startSring);
		assertThat(testMap, is(splitMap));
	}

	/**
	 * 可以使用正则表达式
	 */
	@Test
	public void testSplitPattern() {
		String pattern = "\\d+";
		String text = "foo123bar45678baz";
		String[] expected = new String[] { "foo", "bar", "baz" };
		Iterable<String> values = Splitter.on(Pattern.compile(pattern)).split(text);

		int index = 0;
		for (String value : values) {
			assertThat(value, is(expected[index++]));
		}
	}

	/**
	 * 正则表达式可以直接是一个字符串形式 运行结果与上面的方法一致
	 */
	@Test
	public void testSplitStringPattern() {
		String pattern = "\\d+";
		String text = "foo123bar45678baz";
		String[] expected = new String[] { "foo", "bar", "baz" };
		Iterable<String> values = Splitter.onPattern(pattern).split(text);

		int index = 0;
		for (String value : values) {
			assertThat(value, is(expected[index++]));
		}
	}

	/**
	 * 根据指定分隔符分割字符串，返回的是Iterator类型。
	 */
	@Test
	public void testSplit() {
		String delimiter = "&";
		String text = "foo&bar&baz";
		String[] expected = new String[] { "foo", "bar", "baz" };
		Iterable<String> values = Splitter.on(delimiter).split(text);

		// 遍历元素
		Iterator<String> iter = values.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		int index = 0;
		for (String value : values) {
			assertThat(value, is(expected[index++]));
		}
	}

	/**
	 * trimResults方法的使用，去掉分隔符前后的空格
	 */
	@Test
	public void testSplitTrimResults() {
		String delimiter = "&";
		String text = "foo   &  bar&   baz  ";
		String[] expected = new String[] { "foo", "bar", "baz" };
		Iterable<String> values = Splitter.on(delimiter).trimResults().split(text);
		int index = 0;
		for (String value : values) {
			assertThat(value, is(expected[index++]));
		}
	}

	/**
	 * 使用数字分割字符串
	 */
	@Test
	public void testSplitTrimResultsII() {
		String delimiter = "&";
		String text = "1foo&bar2&2baz3";
		String[] expected = new String[] { "foo", "bar", "baz" };
		Iterable<String> values = Splitter.on(delimiter).trimResults(CharMatcher.JAVA_DIGIT).split(text);
		int index = 0;
		for (String value : values) {
			assertThat(value, is(expected[index++]));
		}
	}

	/** 
	 * 非常标准的字符串分割
	 */
	@Test
	public void testSplitOnCharacter() {
		char delimiter = '|';
		String text = "foo|bar|baz";
		String[] expected = new String[] { "foo", "bar", "baz" };
		Iterable<String> values = Splitter.on(delimiter).split(text);
		int index = 0;
		for (String value : values) {
			assertThat(value, is(expected[index++]));
		}
	}

	/**
	 * 分割以后的空元素用空字符串来代替，不是null
	 */
	@Test
	public void testSplitOnCharacterKeepMissing() {
		char delimiter = '|';
		String text = "foo|bar|||baz";
		String[] expected = new String[] { "foo", "bar", "", "", "baz" };
		Iterable<String> values = Splitter.on(delimiter).split(text);
		int index = 0;
		for (String value : values) {
			assertThat(value, is(expected[index++]));
		}
	}

	/**
	 * 如果分割后的字符串是空字符串，可以使用omitEmptyStrings方法忽略。
	 */
	@Test
	public void testSplitOnCharacterOmitMissing() {
		char delimiter = '|';
		String text = "foo|bar|||baz";
		String[] expected = new String[] { "foo", "bar", "baz" };
		Iterable<String> values = Splitter.on(delimiter).omitEmptyStrings().split(text);
		int index = 0;
		for (String value : values) {
			assertThat(value, is(expected[index++]));
		}
	}
}
