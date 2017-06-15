package exam;

/**
 * 此题考察的是for循环的执行顺序
 * @author TurtusLi
 *
 */
public class Example011 {

    static boolean f(char c) {
	System.out.print(c);

	return true;
    }

    public static void main(String[] args) {
	int i = 0;
	for (f('A'); f('B') && (i < 2); f('C')) {
	    i++;
	    f('D');
	}
    }

}
