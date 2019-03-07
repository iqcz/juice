package book.artconcurrent.ch08;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    static CountDownLatch c = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(3);
            c.countDown();
        }).start();

        c.await();
        System.out.println("End");

    }
}
