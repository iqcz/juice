package exam;

public class Example1136 {

    public static void main(String[] args) {

	try {
	    System.out.println("Hello ");
	    System.exit(1); // 遇到此方法，则不再执行finally中的代码，无论是否是正常退出程序。
	} finally {
	    System.out.println("world");
	}
    }

}
