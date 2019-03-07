package crazy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ExtendedObjectPoolFactory {

	// 定义一个对象池，key 是对象名，value 是实际对象
	private Map<String, Object> objectPool = new HashMap<>();

	private Properties config = new Properties();

	/**
	 * 从指定属性文件中初始化 Properties 对象
	 * @param fileName 配置文件名字
	 */
	public void init(String fileName) {
		try (FileInputStream fis = new FileInputStream(fileName)) {
			config.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end method init

	private Object createObject(String className)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class<?> clazz = Class.forName(className);
		
		return clazz.newInstance();
	} // end method createObject

	public void initPool() {
		for (String name : config.stringPropertyNames()) {
			if (!name.contains("%")) {
				try {
					objectPool.put(name, this.createObject(config.getProperty(name)));
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	} // end method initPool

	public void initProperty() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		for (String name : config.stringPropertyNames()) {
			if (name.contains("%")) {
				String[] objAndProp = name.split("%");
				Object target = getObject(objAndProp[0]);

				String mtdName = "set" + objAndProp[1].substring(0, 1).toUpperCase() + objAndProp[1].substring(1);
				
				Class<?> targetClass = target.getClass();
				
				Method mtd = targetClass.getMethod(mtdName, String.class);
				mtd.invoke(target, config.getProperty(name));

			}
		}
	} // end method initProperty

	private Object getObject(String name) {
		return objectPool.get(name);
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		ExtendedObjectPoolFactory epf = new ExtendedObjectPoolFactory();
		epf.init("extObj.txt");
		epf.initPool();
		epf.initProperty();

		System.out.println(epf.getObject("a"));
	}

}
