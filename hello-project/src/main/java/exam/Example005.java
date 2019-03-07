package exam;

public class Example005 {

	public static void main(String[] args) {
		class A {
			public int i = 3;
		}

		Object o = (Object) new A();
		A a = (A) o;
		System.out.println("i = " + a.i);
	}

}
