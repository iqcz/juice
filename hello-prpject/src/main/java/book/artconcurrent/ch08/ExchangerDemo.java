package book.artconcurrent.ch08;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerDemo {

    private static final Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            String A = "银行流水A";
            try {
                exchanger.exchange(A);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            String B = "银行流水B";
            try {
                String A = exchanger.exchange(B);
                System.out.println(
                        "A和B数据是否一致：" + A.equalsIgnoreCase(B) + ", A录入的是：" + A + ", B录入得是：" + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
