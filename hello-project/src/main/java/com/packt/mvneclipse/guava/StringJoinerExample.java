package com.packt.mvneclipse.guava;

import java.util.List;
import static java.lang.System.out;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class StringJoinerExample {

	public static void main(String[] args) {
		List<String> names = Lists.newArrayList();
		names.add("AA");
		names.add("BB");
		names.add("CC");
		names.add("");
		names.add("EE");
		names.add(null);
		names.add("GG");
		
		// 如果元素中有null，但没有使用skipNulls 处理，则会报NullPointerException。
		String joinedNames = Joiner.on("|").skipNulls().join(names);
		out.println(joinedNames);
		
		String nullNames = Joiner.on("|").useForNull("HH").join(names);
		out.println(nullNames);
	}

}
