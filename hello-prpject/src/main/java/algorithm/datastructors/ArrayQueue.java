package algorithm.datastructors;

/**
 * 顺序循环队列
 * 
 * 循环队列中规定队列的长度只能是数组总长度建1，即有一个位置不放元素。
 * 因此，当head等于tail时，说明队列为空；
 * 当head 等于 (tail + 1) % items.length 时，说明队满。
 * 
 * @author i324779
 */
public class ArrayQueue {

    private final Object[] items;

    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        this.items = new Object[capacity];
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean put(Object item) {
        if (head == (tail + 1) % items.length) {
            // 队列已满
            return false;
        }

        items[tail] = item;
        // tail 标记向后移动一位
        tail = (tail + 1) % items.length;

        return true;
    }

    /**
     * 获取队列头元素，不出队
     * @return
     */
    public Object peek() {
        if (isEmpty()) {
            // 说明队空
            return null;
        }

        return items[head];
    }

    public Object poll() {
        if (isEmpty()) {
            // 说明队空
            return null;
        }

        Object item = items[head];
        // 也可以不用设置
        items[head] = null;
        // head 标记向后移动一位
        head = (head + 1) % items.length;

        return item;
    }

    public boolean isFull() {
        return head == (tail + 1) % items.length;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        if (tail >= head) {
            return tail - head;
        } else {
            return tail + items.length - head;
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        System.out.println(queue.put("A"));
        System.out.println(queue.put("B"));
        System.out.println(queue.put("C"));
        System.out.println(queue.put("D"));

        // true, 当前队列已满，并且D元素没有成功入列。
        System.out.println(queue.isFull());

        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.isEmpty());
    }
}
