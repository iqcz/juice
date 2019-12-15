package algorithm.datastructors;

/**
 * 循环列表
 * @author i324779
 */
public class CLLNode {

    private int data;

    private CLLNode next;

    public CLLNode() {
    }

    public CLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }
}
