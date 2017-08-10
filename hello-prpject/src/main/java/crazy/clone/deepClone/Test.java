package crazy.clone.deepClone;

/**浅拷贝是指拷贝对象时仅仅拷贝对象本身（包括对象中的基本变量），
 * 而不拷贝对象包含的引用指向的对象。深拷贝不仅拷贝对象本身，
 * 而且拷贝对象包含的引用指向的所有对象。
 * 举例来说更加清楚：对象A1中包含对B1的引用，B1中包含对C1的引用。
 * 浅拷贝A1得到A2，A2 中依然包含对B1的引用，B1中依然包含对C1的引用。
 * 深拷贝则是对浅拷贝的递归，深拷贝A1得到A2，A2中包含对B2（B1的copy）的引用，B2 中包含对C2（C1的copy）的引用。
 * **/

// http://www.cnblogs.com/shuaiwhu/archive/2010/12/14/2065088.html
/**
 * @author phideon
 *
 */
public class Test {

	public static void main(String[] args) {
		System.out.println("Before Clone:");

		Address address = new Address("China", "Jilin", "Changjun");

		Employee em1 = new Employee("NoSlient", 32, address);
		System.out.println("Employee 1 info: ");
		System.out.println(em1);
		System.out.println("--------");

		System.out.println("After Clone:");
		Employee em2 = em1.clone();
		
		em2.getAddress().setState("China"); // reference type
		em2.getAddress().setProvince("Liaoning"); // reference type
		em2.getAddress().setCity("Dalian"); // reference type
		em2.setName("Haha");
		em2.setAge(21);

		System.out.println("Employee 2 info:");
		System.out.println(em2);
		
		System.out.println("Employee 1 info: ");
		System.out.println(em1); 
		
	}

}
