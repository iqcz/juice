package com.packt.mvneclipse.guava;

public class PreconditionsExample {

	public static void main(String[] args) {
		String str = null;
//		Preconditions.checkNotNull(str, "Can not be null");
		
		int[] grades = new int[9];
//		Preconditions.checkElementIndex(9, grades.length, "Index out of bounds for values");
		
		int grade = 110;
//		Preconditions.checkArgument(grade <= 100,"Value can't be more than 100");
	}

}
