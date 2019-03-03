package algorithm.datastructors;

/**
 * 如何找到链表的中间节点？
 * 使用两个指针。让第一个指针的移动速度是另一个的两倍。
 * 当第一个指针到达表尾时，另一个指针则指向中间节点。
 * Note：如果链表节点数为奇数，则第（n/2）个节点为中间节点。
 * @author i324779
 */
public class FindListNodeMiddlePosition {

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
}
