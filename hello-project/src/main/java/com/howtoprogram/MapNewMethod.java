package com.howtoprogram;

import java.util.HashMap;
import java.util.Map;

/**
 * Java 8 API Map 添加的新方法
 *
 * @author i324779
 */
public class MapNewMethod {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(16);

        // 当key没有对应的value时才放入新的值，可以防止旧值被覆盖
        map.putIfAbsent("1", "a");

        map.forEach((k, v) -> System.out.println(k + v));

        // 当key没有对应的value时才计算生成新的值
        map.computeIfAbsent("2", e -> e + "1");
        // 当key有对应的value时，使用key和value生成新的值
        map.computeIfPresent("1", (k, v) -> k + v);

        map.remove("1", "a");

        // 获取不到值时使用传入的默认值
        map.getOrDefault("2", "b");

        // 如果key对应的值存在，那么将对应的value和传入的value使用后面的方法合并后作为新值，
        // 否则设置为传入的默认值。
        map.merge("1", "a", (k, v) -> k + v);
    }
}
