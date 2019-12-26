package algorithm.datastructors;

public class MyQueue {

    /**
     * 底层使用数组实现
     */
    private long[] arr;

    /**
     * 有效数据的大小
     */
    private int elements;

    /**
     * 队头
     */
    private int front;

    /**
     * 队尾
     */
    private int end;

    public MyQueue() {
        arr = new long[10];
        elements = 0;
        front = 0;
        end = -1;
    }

    public MyQueue(int maxSize) {
        arr = new long[maxSize];
        elements = 0;
        front = 0;
        end = -1;
    }

    public void insert(int value) {
        arr[++end] = value;
        elements++;
    }

    public long remove() {
        elements--;
        return arr[front++];
    }

    public long peek() {
        return arr[front];
    }

    public boolean isEmpty() {
        return elements == 0;
    }

    public boolean isFull() {
        return elements == arr.length;
    }

}
