package crazy.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	DogUtils utils = new DogUtils();
	utils.method1();
	
	Object result = method.invoke(target, args);
	
	utils.method2();
	
	return result;
    }


    public Object getTarget() {
	return target;
    }


    public void setTarget(Object target) {
	this.target = target;
    }

}
