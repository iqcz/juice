package exam;

public class Example1110 {

    static int i;

    public int test() {
	i++;

	return i;
    }

    public static void main(String[] args) {
	Example1110 e11 = new Example1110();
	e11.test();

	System.out.println(new Example1110().test());

    }

}
