package exam;

class Super {
    
    protected float getNum() {
	return 2.0F;
    }
}

public class Example1131 extends Super {
    
    /**
     * 报错原因：访问权限小于父类要复写的方法
     */
//    float getNum() {
//	return 1.0F;
//    }

    /**
     * 报错原因：返回类型与父类不兼容
     */
//    public void getNum() {
//	
//    }
    
    /**
     * 没问题，参数列表不同
     * @param d
     */
//    private void getNum(double d) {
//	
//    }
    
    /**
     * 报错原因：返回类型与父类不兼容
     */
//    public double getNum() {
//	return 5.0D;
//    }
    
    /**
     * 满足复写要求
     */
    @Override
    public float getNum() {
	return 1;
    }
    
    public static void main(String[] args) {

    }

}
