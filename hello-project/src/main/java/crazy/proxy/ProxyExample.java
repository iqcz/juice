package crazy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyExample {

    public static void main(String[] args) {
	InvocationHandler handler = new MyInvocationHandler();
	Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
		new Class[]{Person.class}, handler);
	
	person.walk();
	person.sayHello("ting");
	
    }

}
