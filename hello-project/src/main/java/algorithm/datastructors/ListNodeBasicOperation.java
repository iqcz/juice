package algorithm.datastructors;

/**
 * @author i324779
 */
public class ListNodeBasicOperation {

    /**
     * 获取单链表长度
     *
     * @param head
     * @return
     */
    static int listLength(ListNode head) {
        int length = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }

        return length;
    }

    private static ListNode constructListNode() {
        int i = 1;
        ListNode head = new ListNode();
        head.setNext(null);
        ListNode tmp;
        ListNode cur = head;

        for (; i < 8; i++) {
            tmp = new ListNode();
            tmp.setData(i);
            tmp.setNext(null);
            cur.setNext(tmp);
            cur = tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = constructListNode();
        System.out.println(listLength(head));
    }
}
