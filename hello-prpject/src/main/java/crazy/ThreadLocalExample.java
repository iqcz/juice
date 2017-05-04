package crazy;

class Account {

	// thread local variable
	private ThreadLocal<String> name = new ThreadLocal<>();

	public Account(String name) {
		this.name.set(name);
		System.out.println("-------" + this.name.get());
	}

	public String getName() {
		return name.get();
	} // end method getName

	public void setName(String name) {
		this.name.set(name);
	} // end method setName

} // end class Account

class MyTest extends Thread {

	private Account account;

	public MyTest(Account account, String name) {
		super(name);
		this.account = account;
	}

	// @Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 6) {
				account.setName(this.getName());
			}

			System.out.println(account.getName() + " Account i: " + i);
		}
	} // end method run

} // end class MyTest

public class ThreadLocalExample {

	public static void main(String[] args) {
		Account at = new Account("Init Name");

		new MyTest(at, "Thread A").start();
		new MyTest(at, "Thread B").start();
	} // end method main

} // end class ThreadLocalExample
