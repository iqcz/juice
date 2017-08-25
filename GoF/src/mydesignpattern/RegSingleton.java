package mydesignpattern;

import java.rmi.registry.Registry;
import java.util.HashMap;

/**
 * 单例的另一种实现方式，单例注册，可以继承。
 * Spring 的单例模式就是基于此种方式实现的。
 * 
 * @author phideon
 *
 */
public class RegSingleton {
	static private HashMap registry = new HashMap();
	// 静态块，在类被加载时自动执行
	static {
		RegSingleton rs = new RegSingleton();
		Registry.put(rs.getClass().getName(), rs);
	}

	// 受保护的默认构造函数，如果为继承关系，则可以调用，克服了单例类不能为继承的缺点
	protected RegSingleton() {
	}

	// 静态工厂方法，返回此类的唯一实例
	public static RegSingleton getInstance(String name){    
	    if(name==null){    
	      name="RegSingleton";
	    }if(registry.get(name)==null){    
	      try{    
	          registry.put(name,Class.forName(name).newInstance());    
	       }catch(Exception ex){ex.printStackTrace();}    
	    }    
	    Return (RegSingleton)registry.get(name);    
	}
}