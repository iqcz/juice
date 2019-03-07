package com.packt.mvneclipse.enumdemo;

public enum Color implements ColorInterface {
	BLUE{
		public String getColor() {
			return "蓝色";
		}
	}, 
	RED{
		public String getColor() {
			return "红色";
		}
	}, 
	BLACK{
		public String getColor() {
			return "黑色";
		}
	};
	
	private Color() {
//		System.out.println("constructor.");
	}

//	@Override
//	public String getColor() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}




