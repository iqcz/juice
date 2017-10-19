package wicked.coo;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * 
 * @author i324779
 *
 * @param <T> 自定义泛型
 */
public class MyGeneric<T> {
    
    SecureRandom random = new SecureRandom();
    
    private ArrayList<T> list;

    public MyGeneric() {
	list = new ArrayList<T>();
    }

    public void add(T element) {
	list.add(element);
    }
    
    public T getRandomElement() {
	int index = random.nextInt(list.size());
	return list.get(index);
    }
    
    public static void main(String [] args) {
	MyGeneric<String> names = new MyGeneric<>();
	names.add("zhangsan");
	names.add("lisi");
	names.add("wangwu");
	names.add("zhaoliu");
	
	// 随机获取list的一个元素
	String name = names.getRandomElement();
	System.out.println(name);
	
	MyGeneric<Integer> numbers = new MyGeneric<>();
	numbers.add(1);
	numbers.add(2);
	numbers.add(3);
	numbers.add(4);
	
	Integer oneNumber = numbers.getRandomElement();
	System.out.println(oneNumber);
    }
}
