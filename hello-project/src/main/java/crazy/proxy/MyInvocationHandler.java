package crazy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    /**
     * 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
     * @param proxy 动态代理的对象
     * @param method 正在执行的方法
     * @param args 执行动态代理对象的方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	System.out.println("正在执行的方法是：" + method);
	
	if(null != args) {
	    System.out.println("下面是执行动态代理对象的方法的实参");
	    for (Object arg : args) {
		System.out.println(arg);
	    }
	} else {
	    System.out.println("调用该方法无需参数");
	}
	
	
	return null;
    }

}
