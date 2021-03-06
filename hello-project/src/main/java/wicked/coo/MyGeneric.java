package wicked.coo;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * @param <T> 自定义泛型
 * @author i324779
 */
public class MyGeneric<T> {

    private final SecureRandom random = new SecureRandom();

    private final ArrayList<T> list;

    public MyGeneric() {
        list = new ArrayList<>();
    }

    public static void main(String[] args) {
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

    public void add(T element) {
        list.add(element);
    }

    public T getRandomElement() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
