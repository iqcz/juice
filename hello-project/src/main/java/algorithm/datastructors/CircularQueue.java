package algorithm.datastructors;

/**
 * 循环队列
 * 当队空时， tail = head
 * 当队满时，(tail + 1) % n = head
 * @author i324779
 */
public class CircularQueue {

    /**
     * 数组
     */
    private String[] items;

    /**
     * 数组大小（长度）
     */
    private int length;
    /**
     * 队头下标
     */
    private int head = 0;
    /**
     * tail 队尾下标
     */
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        length = capacity;
    }

    /**
     * 入队
     * @param item 要入列的元素
     * @return
     */
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % length == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % length;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % length;
        return ret;
    }
}
