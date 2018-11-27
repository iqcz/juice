package algorithm.datastructors;

/**
 * 数据类型：栈
 */
public class MyStack {

    /**
     * 底层是一个数组实现
     */
    private long[] arr;
    private int top;

    public MyStack() {
        arr = new long[10];
        top = -1;
    }

    public MyStack(int maxSize) {
        arr = new long[maxSize];
        top = -1;
    }

    public void push(int value) {
        arr[++top] = value;
    }

    public long pop() {
        return arr[top--];
    }

    public long peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

}
