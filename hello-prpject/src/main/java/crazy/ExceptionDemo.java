package crazy;

public class ExceptionDemo {

	public static void main(String[] args) {

		String str = null;
		
		System.out.println("Start.");
		try {
		 System.out.println(str.toString());
		 System.out.println("In try.");
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			System.out.println("catch");
		}
		System.out.println("Finished.");
		
		for(int i = 0; i < 10; i++) {
			System.out.printf("%d, ", i);
		}
	}

}
