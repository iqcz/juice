package exam;

class Base {
    Base() {
	System.out.println("Base");
    }
}

public class Example009 extends Base {

    public static void main(String[] args) {
	new Base();
	new Example009();
    }

}
