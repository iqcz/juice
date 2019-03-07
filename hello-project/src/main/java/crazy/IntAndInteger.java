package crazy;

/**
 * 注意享元模式
 * @author phideon
 *
 */
public class IntAndInteger {
	public static void main(String ... args) {
		int i = 40;
		Integer in = 40;
		
		
		System.out.println(i == in);
		System.out.println(in.equals(i));
		
		int ii = 400;
		Integer inn = 400;
		Integer innn = new Integer(400);
		
		System.out.println(ii == inn);
		// 注意下面两个比较
		System.out.println(ii == innn); // 一个包装类与原始类型比较
		System.out.println(inn == innn); // 两个包装类的引用类型比较
		
	}
}
