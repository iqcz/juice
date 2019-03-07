package crazy;

/**
 * 使用if...else 语句时，一定要先处理包括范围更小的情况。
 * 
 * @author TurtusLi
 *
 */
public class TestIfError {

    public static void main(String[] args) {
	int age = 125;

	/*
	// error if statement.
	if (age > 20) {
	    System.out.println("青年人");
	} else if (age > 40) {
	    System.out.println("中年人");
	} else if (age > 60) {
	    System.out.println("老年人");
	}
	*/
	

	// right if statement.
	if (age > 60) {
	    System.out.println("老年人");
	} else if (age > 40 && !(age > 60)) {
	    System.out.println("中年人");
	} else if (age > 20 && !(age > 40) && !(age > 60)) {
	    System.out.println("青年人");
	} else {
	    System.out.println("少年人");
	}
    }
}
