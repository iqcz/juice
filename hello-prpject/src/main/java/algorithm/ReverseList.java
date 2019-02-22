package algorithm;

/**
 * @author i324779
 */
public class ReverseList {

    /**
     * 逆置单向链表。
     * @param head 表头
     * @return 逆置后的单向链表。
     */
    ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode nextNode;

        while (head != null) {
            nextNode = head.getNext();
            head.setNext(temp);
            temp = head;
            head = nextNode;
        }

        return temp;
    }
}
