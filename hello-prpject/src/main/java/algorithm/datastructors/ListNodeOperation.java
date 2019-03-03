package algorithm.datastructors;

/**
 * 单链表的一些操作
 * @author i324779
 */
public class ListNodeOperation {

    /**
     * 找到链表的中间节点
     * 使用两个指针。让第一个指针的移动速度是另一个的两倍。
     * 当第一个指针到达表尾时，另一个指针则指向中间节点。
     * Note：如果链表节点数为奇数，则第（n/2）个节点为中间节点。
     * @param head
     * @return
     */
    ListNode findMiddle(ListNode head) {
        ListNode ptr1x, ptr2x;
        ptr1x = head;
        ptr2x = head;
        int i = 0;
        // 不断循环，直至达到表尾（next后继指针为null，就表示达到最后一个节点）
        while (ptr1x.getNext() != null) {
            if (i == 0) {
                ptr1x = ptr1x.getNext();
                i = 1;
            } else {
                // 两个指针都后移
                ptr1x = ptr1x.getNext();
                ptr2x = ptr2x.getNext();
                i = 0;
            }
        }
        return ptr2x;
    }

    /**
     * 从表尾开始输出链表。
     * @param head
     */
    void printListFromEnd(ListNode head) {
        if (head == null) {
            return;
        }

        printListFromEnd(head.getNext());
        System.out.println(head.getData());
    }

    /**
     * 检查链表的长度是奇数还是偶数。
     * 使用一个在链表中每次向后移动两个节点的指针。
     * 最后，如果指针值为null，那么聊表长度为偶数；
     * 否则指针指向表尾节点，链表长度为奇数。
     * @param head
     * @return
     */
    public int isLinkedListLengthEven(ListNode head) {
        while (head != null && head.getNext() != null) {
            head = head.getNext().getNext();
            if (head == null) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
