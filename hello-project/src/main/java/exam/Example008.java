package exam;

public class Example008 {

    public static void main(String[] args) {

	class A {
	    public int i = 3;
	}

	Object o = new A();
	A a = (A) o;
	System.out.println("i = " + a.i);
    }

}
