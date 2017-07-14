package exam;

public class CircleNumber {

    public static void main(String[] args) {
	for (int i = 10; i < 10000; i++) {
	    if (isCircleNumber(i)) {
		System.out.println(i + " 是回文数。");
	    }
	}
    }

    private static boolean isCircleNumber(int num) {
	int oldValue = num;
	int temp = 0;
	while (num > 0) {
	    temp = temp * 10 + num % 10;
	    num /= 10;
	}

	return temp == oldValue;
    }

}
