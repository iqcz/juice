package com.packt.mvneclipse.javainanutshell;

/**
 *
 * 使用内部类实现单例，既可以实现延迟加载，也可不必使用同步关键字，是一种比较完善的实现
 *
 * @author liyanxue
 */
public class StaticSingleton {

    /**
     * 构造方法私有化，不允许调用类直接通过构造方法实例化。
     */
    private StaticSingleton() {
	System.out.println("StaticSingleton is created...");
    }

    /**
     * 用内部类创建。
     */
    private static class SingletonHolder {

	private static StaticSingleton instance = new StaticSingleton();
    }

    /**
     * 提供外部调用的方法。
     * 
     * @return
     */
    public static StaticSingleton getInstance() {
	return SingletonHolder.instance;
    }

    /**
     * main方法，测试类。
     */
    public static void main(String[] args) {
	StaticSingleton.getInstance();
    }
}