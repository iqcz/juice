package algorithm.datastructors;

import java.util.Arrays;

/**
 * 数据类型：栈
 */
public class MyStack {

    private static final int DEFAULT_SIZE = 10;

    /**
     * 底层是一个数组实现
     */
    private long[] arr;

    /**
     * equals top
     *  */
    private int size;

    public MyStack() {
        arr = new long[DEFAULT_SIZE];
    }

    public MyStack(int maxSize) {
        arr = new long[maxSize];
    }

    public void push(int value) {
        // 扩容
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, size * 2);
        }
        arr[size++] = value;
    }

    public long pop() {
        long value = this.peek();
        size--;
        return value;
    }

    public long peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty.");
        }
        return arr[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(1);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.size());

        stack.push(3);
        System.out.println(stack.size());

        System.out.println(stack.peek());
        System.out.println(stack.size());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }

}
