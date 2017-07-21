package com.packt.java8inaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 这种做法有严重的缺陷。 不可修改的list只是可修改list的包装。 有意的是，将变量名为`list`。
 * 不能使用`list2`变量修改列表。但是，仍然可以使用`list `变量来修改列表， 并且在使用`list2`变量读取列表时将会反映出修改。
 * 下面包含一个完整的程序来创建一个不可修改的list，并显示如何在以后更改其内容。
 * 
 * @author TurtusLi
 *
 */

public class PreJDK9UnmodifiableList {

    // 注意，此示例使用多个语句来创建和填入不可修改的list。
    // 如果需要在类中声明和初始化不可修改的列表作为实例或静态变量，
    // 则该方法不起作用，因为它涉及多个语句。 这样一个声明需要简单，紧凑，并且包含在一个声明中。
    // 如果在类中使用以前的代码来实例变量，那么代码将类似于以下代码：
    List<Integer> list4 = new ArrayList<>();
    {
	list4.add(100);
	list4.add(200);
	list4 = Collections.unmodifiableList(list4);
    }
    
    // 还有其他方式来声明和初始化一个不可修改的list，例如使用数组并将其转换为list。 其中三种方式如下：
    // Using an array and converting it to a list
    List<Integer> list5 = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(100, 200)));
    // Using an anonymous class
    List<Integer> list6 = Collections.unmodifiableList(new ArrayList<Integer>() {
	private static final long serialVersionUID = 1L;
	{
	    add(100);
	    add(200);
	}
    });
    // Using a stream
    List<Integer> list7 = Collections.unmodifiableList(Stream.of(100, 200).collect(Collectors.toList()));
 	
    public static void main(String[] args) {

	List<Integer> list = new ArrayList<>();
	list.add(100);
	list.add(200);
	System.out.println("list = " + list);

	// Create an unmodifiable list
	List<Integer> list2 = Collections.unmodifiableList(list);
	System.out.println("list2 = " + list2);
	// Let us add an element using list
	list.add(300);

	// Print the contents of the list using both
	// variables named list and list2
	System.out.println("list = " + list);
	System.out.println("list2 = " + list2);

	// 输出显示，只要保留原始列表的引用，就可以更改其内容，并且不可修改的list也不是真正不可修改的！
	// 解决此问题的方法是使用新的不可修改list引用来覆盖原始引用变量，如下所示：
	List<Integer> list3 = new ArrayList<>();
	list3.add(100);
	list3.add(200);
	// Create an unmodifiable list and store it in list
	list3 = Collections.unmodifiableList(list3);
	
	
    }
}