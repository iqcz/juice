package com.packt.ming;

import java.util.ArrayList;
import java.util.List;

public class List2Array {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(4);
        names.add("Zhangsan");
        names.add("Lisi");
        names.add("Wangwu");
        names.add("Zhaoliu");

        String[] namesArr = names.toArray(new String[0]);
        // names.stream().toArray(String[]::new);

        for (String name : namesArr) {
            System.out.println(name);
        }
    }
}
