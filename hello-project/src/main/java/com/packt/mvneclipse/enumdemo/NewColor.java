package com.packt.mvneclipse.enumdemo;

public enum NewColor {

	RED("红色", 5), GREEN("绿色", 6), BLUE("蓝色", 7);

	private String name;
	private int index;

	NewColor(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public static String getName(int index) {
		String name = "";
		for (NewColor nc : NewColor.values()) {
			if (nc.getIndex() == index) {
				name = nc.getName();
				break;
			}
		}
		return name;
	}

	public String getName() {
		return name;
	}

	public static void setName(int index, String name) {
		for (NewColor nc : NewColor.values()) {
			if (nc.getIndex() == index) {
				nc.name = name;
				return;
			}
		}
	}

	public int getIndex() {
		return index;
	}

	public static void setIndex(int index, String name) {
		for (NewColor nc : NewColor.values()) {
			if (nc.getName() == name) {
				nc.index = index;
				return;
			}
		}
	}
}
