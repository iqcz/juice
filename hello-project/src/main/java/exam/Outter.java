package exam;

/**
 * 定义并访问内部类的方式
 * @author TurtusLi
 *
 */
public class Outter {

    String str = "Outter";

    class Inner {

        int i = 9;

        public String sayHello() {
            return str;
        }
    }

    public static void main(String[] args) {
        Outter o = new Outter();
        Outter.Inner inner = o.new Inner();

        System.out.println(inner.i);
        System.out.println(inner.sayHello());

        //	Outter.Inner inner2 = new Outter().new Inner();
    }

}
