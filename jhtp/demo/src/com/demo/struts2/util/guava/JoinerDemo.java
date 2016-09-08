package com.demo.struts2.util.guava;

import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class JoinerDemo {

	public static void main(String[] args) {

		String expectedString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
		
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C","Redskins");
        testMap.put("New York City","Giants");
        testMap.put("Philadelphia","Eagles");
        testMap.put("Dallas","Cowboys");
        
        String rtndStr = Joiner.on("#").withKeyValueSeparator("=").join(testMap);
        
        System.out.println(expectedString.equals(rtndStr));
        List<String> strList= Lists.newArrayList();
        strList.add("one");
        strList.add(null);
        strList.add("three");
        
        String rtn1 = Joiner.on("|").useForNull("MissingValue").join(strList);
        System.out.println(rtn1);
	}

}
