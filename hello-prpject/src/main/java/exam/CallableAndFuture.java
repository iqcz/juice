package exam;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {

    public static void main(String[] args) {
	ExecutorService threadPool = Executors.newSingleThreadExecutor();

	// 启动线程
	Future<String> future = threadPool.submit(() -> "Hello, world");
	
	try {
	    System.out.println("waiting thread to finish.");
	    System.out.println(future.get()); // 等待线程结束，并获取返回结果
	    
	    threadPool.shutdown();
	} catch (InterruptedException | ExecutionException e) {
	    e.printStackTrace();
	}
    }
}
