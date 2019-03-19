package exam;

/**
 * String 是不可变类
 * @author TurtusLi
 *
 */
public class Example001 {

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        String str = new String("good");
        char[] ch = { 'a', 'b', 'c' };

        Example001 e1 = new Example001();
        e1.change(str, ch);

        System.out.print(str + " and ");

        System.out.print(ch);

    }

}
