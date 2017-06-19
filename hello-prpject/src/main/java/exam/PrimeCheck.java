package exam;

/***
 * 判断一个数字是否是素数
 * @author TurtusLi
 *
 */
public class PrimeCheck {

    public static void main(String[] args) {
	PrimeCheck pc = new PrimeCheck();
	
	System.out.println(pc.isPrime(11));
    }

    public boolean isPrime(long n) {
	if (n <= 1) {
	    return false;
	}
	if (n == 2) {
	    return true;
	}
	if (n % 2 == 0) {
	    return false;
	}
	for (long i = 3; i < n; i += 2) {
	    if (n % i == 0) {
		return false;
	    }
	}
	return true;
    }
    
    /**
     * 减少了循环次数
     * @param n
     * @return
     */
    public boolean isPrimeFast(long n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        long limit = (long) Math.sqrt(n);
        for (long i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
