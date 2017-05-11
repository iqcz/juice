package crazy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {

	public static void main(String[] args) {
		RtnThread rt = new RtnThread();

		// 使用FutureTask来包装 Callable 对象
		FutureTask<Integer> task = new FutureTask<>(rt);

		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "的循环变量的i 的值是：" + i);

			if (i == 20) {
				new Thread(task, "有返回值的线程").start();
			}
		}

		try {
			System.out.println("子线程的返回值：" + task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}

class RtnThread implements Callable<Integer> {

	/**
	 * 实现 call 方法，作为线程的执行体
	 */
	@Override
	public Integer call() throws Exception {
		int i = 0;

		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "的循环变量的i 的值是：" + i);
		}
		return i;
	} // end method call

}
