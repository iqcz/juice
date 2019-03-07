package com.packt.mvneclipse.javainanutshell;

/**
 * 
 * @author Phideon Lee
 *
 *只能在同类型的数组之间赋值
 *任何类型的数组都可以赋值给 Object
 *数组可以赋值给接口，例如，Comparable，Cloneable，Serializable。
 *
 */
public class ArrayConcersion {

	public static void main(String[] args) {

		String[] arrayOfString = null;
		
		int[] arrayOfInt = {};
		
		int[][] arrayOfArrayOfInt = null;
		
		Object[] oa = arrayOfString;
		
		Object obj = arrayOfString;
		
		obj = arrayOfArrayOfInt;
		
		Comparable[] ca = arrayOfString;
	}

}
