package exam;

/**
 * finally 里面的语句在return之前执行。
 * @author TurtusLi
 *
 */
public class Example003 {

    public static int testException(int i) throws Exception {
	try {
//	    return i / 5;
	    return 5 / i;
	} catch (Exception e) {
	    throw new Exception("exception in a aMethod");
	} finally {
	    System.out.println("finally");
	}
    }

    public static void main(String[] args) {
	try {
	    System.out.println(testException(0));
	} catch (Exception e) {
	    System.out.println("exception in main");
	}

	System.out.println("finished");
    }

}
