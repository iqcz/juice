package crazy.proxy1;

/**
 * 基本类型只比较数值大小，不在乎数值的类型。 
 * @author TurtusLi
 *
 */
public class NumberCompare {

    public static void main(String[] args) {
	int inum = 5;
	float fnum = 5.0f;
	System.out.println(inum == fnum);
    }

}
