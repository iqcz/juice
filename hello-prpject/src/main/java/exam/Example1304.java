package exam;

public class Example1304 {

    public void someOuterMethod() {
	//
	new Inner();
    }

    public class Inner {

    }

    public static void main(String[] args) {
	Example1304 outer = new Example1304();

	// 定义内部类
	Example1304.Inner inner = new Example1304().new Inner();

	Example1304.Inner inner2 = outer.new Inner();

	// error
	// new outer.Inner();
    }

}
