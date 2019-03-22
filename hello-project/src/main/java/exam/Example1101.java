package exam;

/**
 * 在父类和子类都有同名的方法f，形参列表不同，两个类并不冲突，不错报错。
 * 
 * @author TurtusLi
 *
 */

class A {

    public int f(int a) {
        return a + 1;
    }

    public int f(int a, char c) {
        return 77;
    }

}

public class Example1101 extends A {

    @Override
    public int f(int a, char c) {
        return a + 2;
    }

    public static void main(String[] args) {
        Example1101 b = new Example1101();
        System.out.println(b.f(0));
        System.out.println(b.f(1, '3'));

        A a = new A();
        System.out.println(a.f(1, '4'));

    }

}
