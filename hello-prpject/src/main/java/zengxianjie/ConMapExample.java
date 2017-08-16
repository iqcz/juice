package zengxianjie;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 把HashMap替换为CocurrentHashMap，去掉synchronized关键字，
 * 还会有问题，是什么问题？
 * @author Yanxue.Li
 *
 */
public class ConMapExample {

	private ConcurrentHashMap<String, Integer> map = 
			new ConcurrentHashMap<>();

	public void add(String key) {
		Integer value = map.get(key);

		if (null == value) {
			map.put(key, 1);
		} else {
			map.put(key, value + 1);
		}
	}
	
	/*
	private HashMap<String, Integer> map = new HashMap<>();

	public synchronized void add(String key) {
		Integer value = map.get(key);

		if (null == value) {
			map.put(key, 1);
		} else {
			map.put(key, value + 1);
		}
	}
	*/
}
