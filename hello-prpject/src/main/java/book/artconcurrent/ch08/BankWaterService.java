package book.artconcurrent.ch08;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BankWaterService implements Runnable {

    // 创建4个屏障，处理完之后执行当前类的run方法
    private CyclicBarrier barrier = new CyclicBarrier(4, this);

    // 假设只有4个sheet，所以只启动4个线程
    private Executor executor = Executors.newFixedThreadPool(4);

    // 保存每个sheet页的计算出的银行流水结果
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                // 计算当前sheet页的银行流水数据
                int result = getResult();
                System.out.println("Per sheet:" + result);
                sheetBankWaterCount.put(Thread.currentThread().getName(), result);

                // 银行流水计算完成，插入一个屏障
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public int getResult() {
        SecureRandom random = new SecureRandom();
        return random.nextInt(10);
    }

    @Override
    public void run() {
        int result = 0;
        // 汇总每个sheet页计算出的结果
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }

        // 将结果输出
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService service = new BankWaterService();
        service.count();
    }
}
