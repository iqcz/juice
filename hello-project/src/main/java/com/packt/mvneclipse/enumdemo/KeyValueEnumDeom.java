package com.packt.mvneclipse.enumdemo;

public class KeyValueEnumDeom {

	public static void main(String[] args) {
		System.out.println(KeyValueEnum.FEMALE.getKey());
		
		KeyValueEnum[] kvs = KeyValueEnum.values();
		for(KeyValueEnum ky : kvs) {
			System.out.println(ky.name());
			System.out.println(ky.getKey());
			System.out.println(ky.ordinal());
			System.out.println(ky.toString());
			System.out.println("-----------");
		}
	}

}
