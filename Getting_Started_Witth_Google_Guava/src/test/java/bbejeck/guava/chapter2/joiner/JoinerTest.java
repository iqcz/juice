package bbejeck.guava.chapter2.joiner;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.google.common.io.CharSink;
import com.google.common.io.Files;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.File;
import java.io.Writer;
import java.util.Map;

/**
 * User: Bill Bejeck Date: 3/15/13 Time: 9:04 PM
 *
 * This class contains various unit tests for working with the Joiner class
 */
public class JoinerTest {

	/**
	 * 把一个Map的key-value以指定分隔符分割，
	 * 每个元素之间再使用指定分隔符进行连接，
	 * 最后形成一个字符串。
	 */
	@Test
	public void testMapJoiner() {
		// Using LinkedHashMap so that the original order is preserved
		String expectedString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
		Map<String, String> testMap = Maps.newLinkedHashMap();
		testMap.put("Washington D.C", "Redskins");
		testMap.put("New York City", "Giants");
		testMap.put("Philadelphia", "Eagles");
		testMap.put("Dallas", "Cowboys");
		
		String returnedString = Joiner.on("#").withKeyValueSeparator("=").join(testMap);
		assertThat(returnedString, is(expectedString));
	}

	/**
	 * 用指定分隔符连接数组里的每个元素，
	 * 最后形成一个字符串。
	 */
	@Test
	public void testJoinStrings() {
		String[] values = new String[] { "foo", "bar", "baz" };
		String returned = Joiner.on("|").join(values);
		assertThat(returned, is("foo|bar|baz"));
	}

	/**
	 * 连接StringBuilder对象的使用方法
	 */
	@Test
	public void testJoinStringBuilder() {
		String[] values = new String[] { "foo", "bar", "baz" };
		StringBuilder builder = new StringBuilder();
		StringBuilder returned = Joiner.on("|").appendTo(builder, values);
		
		assertThat(returned, is(builder));
		assertThat(returned.toString(), is("foo|bar|baz"));
	}

	@Test
	public void testJoinFileWriter() throws Exception {
		File tempFile = new File("testTempFile.txt");
		tempFile.deleteOnExit();
		
		// CharSink is the class in the Guava
		CharSink charSink = Files.asCharSink(tempFile, Charsets.UTF_8);
		Writer writer = charSink.openStream();
		String[] values = new String[] { "foo", "bar", "baz" };
		Joiner.on("|").appendTo(writer, values);
		writer.flush();
		writer.close();
		
		String fromFileString = Files.toString(tempFile, Charsets.UTF_8);
		assertThat(fromFileString, is("foo|bar|baz"));

	}

	/**
	 * 如果数组元素中null， 可以使用skipNull方法，忽略null元素
	 */
	@Test
	public void testJoinStringsSkipNull() {
		String[] values = new String[] { "foo", null, "bar" };
		String returned = Joiner.on("#").skipNulls().join(values);
		assertThat(returned, is("foo#bar"));
	}

	/**
	 * 如果元素为null，使用useForNull方法指定换一个默认值
	 */
	@Test
	public void testJoinStringsUseForNull() {
		String[] values = new String[] { "foo", null, "bar" };
		String returned = Joiner.on("#").useForNull("missing").join(values);
		assertThat(returned, is("foo#missing#bar"));
	}

	/**
	 *  如果元素为null，直接使用join方法，会抛出异常。
	 */
	@Test(expected = NullPointerException.class)
	public void testJoinStringsNoNullHandler() {
		String[] values = new String[] { "foo", null, "bar" };
		Joiner.on("#").join(values);
		fail("Should not get here");
	}
}
