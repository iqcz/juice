package com.packt.mvneclipse.enumdemo;

public class DeepMenuDemo {

	public static void main(String[] args) {

		System.out.println(NewColor.RED.getIndex() + "-->" + NewColor.RED.getName());
		System.out.println(NewColor.GREEN.getIndex() + "-->" + NewColor.GREEN.getName());
		System.out.println(NewColor.BLUE.getIndex() + "-->" + NewColor.BLUE.getName());
		
		NewColor.setName(5, "粉红");
		System.out.println("5--->" + NewColor.getName(5));
		
		NewColor.setIndex(8, "蓝色");
		System.out.println("8--->" + NewColor.getName(8));
		
	}

}
