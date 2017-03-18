package com.packt.ming;

import java.math.BigDecimal;

public class BigdecimalDemo {

    static final int location = 10;
    
    public BigDecimal div(double v1, double v2) {
	return div(v1, v2, location);
    }
    
    public BigDecimal div(double v1, double v2, int b) {
	if(b< 0) {
	    System.out.println("不能小于0");
	}
	BigDecimal b1 = new BigDecimal(Double.toString(v1));
	BigDecimal b2 = new BigDecimal(Double.toString(v2));
	
	return b1.divide(b2, b, BigDecimal.ROUND_HALF_UP);
    }
    public static void main(String[] args) {
	BigdecimalDemo bd = new BigdecimalDemo();
	System.out.println(bd.div(10, 2));
	System.out.println(bd.div(-7.5, 8.9, 5));
    }
    

}
