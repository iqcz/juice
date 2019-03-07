package exam.ucar;

public class CSubClass extends BAbstract {

    public static void main(String... args) {
	CSubClass sub = new CSubClass();
	System.out.println(sub.x);
	sub.printX();
	
	System.out.println(AInteraface.x);
	
	AInteraface a = new CSubClass();
	System.out.println(a.x);
    }

}
