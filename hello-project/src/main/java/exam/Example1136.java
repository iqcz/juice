package exam;

/**
 * 关于finally是否执行的例子。
 * 正常情况下，finally都会执行，而且是在返回return之前执行，
 * 但是遇到System.exit(1)还是System.exit(0)，
 * 也就是不管程序是否正常推出，都不再执行final有里的语句了。
 * @author TurtusLi
 *
 */
public class Example1136 {

    public static void main(String[] args) {

        try {
            System.out.println("Hello ");
            System.exit(1); // 遇到此方法，则不再执行finally中的代码，无论是否是正常退出程序。
        } finally {
            System.out.println("world");
        }
    }

}
