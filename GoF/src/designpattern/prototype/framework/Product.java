package designpattern.prototype.framework;

import java.lang.Cloneable;

/**
 * 原型模式是通过Cloneable来实现的
 * @author phideon
 *
 */
public interface Product extends Cloneable {
	
	public abstract void use(String s);

	public abstract Product createClone();
}
