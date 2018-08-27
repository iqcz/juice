package com.packt.mvneclipse.guava;

import com.google.common.base.CharMatcher;

public class CharMatcherExample {

    public static void main(String[] args) {
        String stringWithLinebreaks = "This is an example\n" + "of a String with linebreaks\n"
                + "we want on one line";

        // replaceFrom 只是替换一个空格或换行，或tab等
        String str1 = CharMatcher.BREAKING_WHITESPACE.replaceFrom(stringWithLinebreaks, " ");
        System.out.println(str1);

        System.out.println("--------------------");

        // collapseFrom 替换多个空格或tab。
        String tabsAndSpaces = "String  with      spaces     and           tabs";
        String str2 = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, '|');
        System.out.println(str2);

        System.out.println("--------------------");

        // 只保留数字的字符串
        String lettersAndNumbers = "foo989yxbar234";
        String str3 = CharMatcher.JAVA_DIGIT.retainFrom(lettersAndNumbers);
        System.out.println(str3);

        System.out.println("--------------------");

        CharMatcher cm = CharMatcher.inRange('A', 'N');
        String s4 = cm.retainFrom("aaaABbbTEccCdN!4ddDEeee");
        System.out.println(s4);
    }

}
