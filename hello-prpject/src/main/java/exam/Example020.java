package exam;

/**
 * getClass方法的释义是：返回此Object的运行时类。
 */
import java.util.Date;

public class Example020 extends Date {

    /**
     * 
     */
    private static final long serialVersionUID = -7554285016922148072L;

    public void test() {
	System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
	new Example020().test();
	System.out.println(new Date().getClass().getName());

	// 获取父类
	System.out.println(new Example020().getClass().getSuperclass().getName());

    }

}
