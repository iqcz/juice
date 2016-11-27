package com.packt.mvneclipse.enumdemo;

/**
 * used for drop down list(key-value) 
 * @author TurtusLi
 *
 */
public enum KeyValueEnum {

	MALE(1), FEMALE(2), UNKNOWN(0);
	
	private int key;
	
	private KeyValueEnum(int key) {
		this.setKey(key);
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
