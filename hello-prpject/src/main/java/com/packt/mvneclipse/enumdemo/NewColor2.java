package com.packt.mvneclipse.enumdemo;

/**
 * 这个枚举展示抽象方法在枚举中的使用。
 * @author TurtusLi
 *
 */
public enum NewColor2 {
	RED {
		@Override
		public String getColor() {
			// TODO Auto-generated method stub
			return "紅色";
		}
	}, BLUE {
		@Override
		public String getColor() {
			// TODO Auto-generated method stub
			return "藍色";
		}
	}, BLACK {
		@Override
		public String getColor() {
			// TODO Auto-generated method stub
			return "黑色";
		}
	};
	
	public abstract String getColor();
}
