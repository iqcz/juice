package com.packt.mvneclipse.javainanutshell;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class SecondMaxNumber {

    public static void main(String[] args) {
        Integer[] data = {34, 2, 98, 32, 98, 100, 20, 60, 22};
        System. out.println(getSecond(data));
  }
  
   public static int getSecond(Integer[] data) {
         // 转换为列表
        List<Integer> dataList = Arrays. asList(data);
        
         // 转换为TreeSet，删除重复元素并升序排列
        TreeSet<Integer> ts = new TreeSet<Integer>(dataList);
        
         // 取得比最大值小的最大值，也就是老二。
         return ts.lower(ts.last());
  }

}
