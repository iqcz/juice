package com.packt.mvneclipse.javainanutshell;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Turtus
 */
public class Client {

    public static void main(String[] args) {
        String[] strs = {"张三（Z）", "李四（L）", "王五（W）"};

        // Unicode 码值进行比较
        Arrays.sort(strs);

        int i = 1;
        for (String str : strs) {
            System.out.println(i++ + ". " + str);
        }

        System.out.println("使用 Collator 类进行排序");

        // 定义一个中文排序器
        Comparator c = Collator.getInstance(Locale.CHINA);
        Arrays.sort(strs, c);

        int j = 1;
        for (String str : strs) {
            System.out.println(j++ + ". " + str);
        }

    }
}
