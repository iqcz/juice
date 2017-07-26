package exam;

/**
 * Java程序初始化工作可以在许多不同的代码中来完成，它们执行的顺序如下：
 * 父类静态变量
 * 父类静态代码块
 * 子类静态变量
 * 子类静态代码块
 * 父类非静态变量
 * 父类非静态代码块
 * 父类构造函数
 * 子类非静态变量
 * 子类非静态代码块
 * 子类构造函数
 * 
 * 
 * 注意，只有方法具有多态性，属性则没有。
 * @author TurtusLi
 *
 */
class BaseI {
    int num = 1;

    public BaseI() {
	this.print();
	num = 2;
    }

    public void print() {
	System.out.println("Base.num = " + num);
    }
}

public class Example1423 extends BaseI {

    int num = 3;

    public Example1423() {
	this.print();

	num = 4;
    }

    // 去掉这个复写方法，运行看效果
    @Override
    public void print() {
	System.out.println("Sub.num = " + num);
    }

    public static void main(String[] args) {
	BaseI b = new Example1423();
	System.out.println(b.num);
    }

}
