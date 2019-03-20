package exam;

/**
 * 1 + 3 + 5 ... + 99
 * @author TurtusLi
 *
 */
public class Example012 {

    public static void main(String[] args) {

        int sum = 0;
        for (int i = 1; i < 100; i += 2) {
            sum += i;
        }

        System.out.println(sum);
    }

}
