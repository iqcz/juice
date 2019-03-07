package crazy;

public class RunnableExample implements Runnable{

	private int i;
	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			if(i == 20) {
				RunnableExample st = new RunnableExample();
				new Thread(st, "New Thread 1").start();
				new Thread(st, "New Thread 2").start();
			}
		}
	}


}
