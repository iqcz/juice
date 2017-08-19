package bbejeck.guava.chapter2.charmatcher;

import com.google.common.base.CharMatcher;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 * User: Bill Bejeck
 * Date: 3/19/13
 * Time: 11:04 PM
 */
public class CharMatcherTest {

	/**
	 * 用空格替换字符串中的换行符
	 */
    @Test
    public void testRemoveLinebreaks(){
        String stringWithLinebreaks = "This is an example\n"+
                                      "of a String with linebreaks\n"+
                                      "we want on one line";
        String expected = "This is an example of a String with linebreaks we want on one line";
        String scrubbed = CharMatcher.BREAKING_WHITESPACE.replaceFrom(stringWithLinebreaks,' ');
        
        assertThat(scrubbed,is(expected));
    }

    /**
     * 把多个空格替换为一个空格
     */
    @Test
    public void testRemoveWhiteSpace(){
        String tabsAndSpaces = "String  with      spaces     and           tabs";
        String expected = "String with spaces and tabs";
        String scrubbed = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces,' ');
        assertThat(scrubbed,is(expected));
    }

    /**
     * 去调字符串的前后空格，并替换字符串中间的多个空格为一个空格
     */
    @Test
    public void testTrimRemoveWhiteSpace(){
        String tabsAndSpaces = "    String  with      spaces     and           tabs";
        String expected = "String with spaces and tabs";
        String scrubbed = CharMatcher.WHITESPACE.trimAndCollapseFrom(tabsAndSpaces,' ');
        assertThat(scrubbed,is(expected));
    }

    /**
     * 保留字符串中的数字
     */
    @Test
    public void testRetainFrom(){
        String lettersAndNumbers = "foo989yxbar234";
        String expected = "989234";
        String retained = CharMatcher.JAVA_DIGIT.retainFrom(lettersAndNumbers);
        assertThat(expected,is(retained));
    }

    /**
     * 保留区间的字符
     */
    @Test
    public void testCombineMatchers(){
        CharMatcher cm = CharMatcher.inRange('A','E');
        assertThat(cm.retainFrom("aaaABbbccCdddDEeee"),is("ABCDE"));
    }
}
