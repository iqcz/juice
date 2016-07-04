package com.demo.struts2.util.guava;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

public class StringsDemo {

	public static void main(String... arags) {
		
		System.out.println(Strings.padEnd("foo", 6, 'x'));
		String str = null;
		System.out.println(Strings.nullToEmpty(str));

		// Preconditions.checkArgument();
		String str1 = Objects.firstNonNull(null, "Default Value");
		System.out.println(str1);
		Map<String, Integer> testmap = new HashMap<String, Integer>();
		
		String strs = "1,2,3,5,";
		String s = strs.substring(0, strs.lastIndexOf(','));
		System.out.println(s);
		
		List<String> strsList = new ArrayList<>();
		strsList.add("One");
		strsList.add("Two");
		strsList.add("Three");
		String json = "";
		for(int i = 0; i < strsList.size(); i++) {
			json += "{policyNo:" + strsList.get(i) + "},";
		}
		json = json.substring(0, json.lastIndexOf(','));
		System.out.println(json);
		
		String stre = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = format.parse(stre);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(new Timestamp(date.getTime()));
		
		
	}
}