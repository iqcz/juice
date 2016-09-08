package com.demo.struts2.util.guava;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Objects;
import com.google.common.base.Strings;

public class StringsDemo {

	public static void main(String... arags) {
		
		System.out.println(Strings.padEnd("foo", 6, 'x'));
		String str = "null";
		System.out.println("Str:" + Strings.nullToEmpty(str));

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
		
		System.out.println("+++++++++++++++++++++++");
		
		
		Function<String, Date> func = new Function<String, Date>() {
			@Override
			public Date apply(String input) {
				Date date = new Date();
				try {
					date =  new SimpleDateFormat("dd/mm/yyyy").parse(input);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return date;
			}
		};
		System.out.println(func.apply("08/12/2016"));
		
		String constantOptions1 = "10, 100";
		System.out.println("dd: " + constantOptions1.contains("12"));
		
		
		System.out.println("==============");
		String sb = "±à";
		byte[] sbs = sb.getBytes();
		for(int i = 0; i < sbs.length; i++) {
			System.out.println(sbs[i]);
		}
		
		System.out.println("==============");
		
		byte[] sbsu = sb.getBytes(Charset.forName("UTF-8"));
		for(int i = 0; i < sbsu.length; i++) {
			System.out.println(sbsu[i]);
		}
		double d = 4.98D;
		long num = 677L;
		float fNn = 9.42F;
		
		System.out.println("=====================");
		List<String> strList = new ArrayList<>();
		List<Integer> intList = new ArrayList<>();
		System.out.println(strList.getClass() == intList.getClass());
		
		
		System.out.println("==========================");
		
		
		
		String strDate = "19881212";
		System.out.println(stringToTimestamp(strDate));
	}
	
	
	private static Timestamp stringToTimestamp(String str) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date date = format.parse(str);
			return new Timestamp(date.getTime());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}