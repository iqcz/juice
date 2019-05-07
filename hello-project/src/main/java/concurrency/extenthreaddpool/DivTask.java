package concurrency.extenthreaddpool;

/**
 * 计算两个数的商。
 * @author i324779
 */
public class DivTask implements Runnable {
    private int a;
    private int b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a / b;
        System.out.println(re);
    }
}
