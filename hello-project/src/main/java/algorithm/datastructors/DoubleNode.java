package algorithm.datastructors;

public class DoubleNode {

    private int value;
    private DoubleNode previous;
    private DoubleNode next;

    public DoubleNode(int value) {
        this.value = value;
    }

    public DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode nxt;

        while (head != null) {
            nxt = head.next;
            head.next = pre;
            head.previous = nxt;
            pre = head;
            head = nxt;
        }
        return pre;
    }
}
