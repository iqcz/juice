package crazy;

/**
 * 打印三角形图案
 * @author i324779
 *
 */
public class Triangle {

    public static void main(String[] args) {
	Triangle triangle = new Triangle();
	triangle.printTriangle(3);
    }

    /**
     * 
     * @param layer 层级
     */
    public void printTriangle(int layer) {
	for (int i = 0; i < layer; i++) {
	    for (int j = 0; j < layer - i; j++) {
		System.out.print(" "); // 输出前面的空格
	    }

	    for (int j = 0; j < i + 1; j++) {
		System.out.print(i + 1 + " "); // 输出数字和空格
	    }

	    System.out.println();
	}
    }
}
