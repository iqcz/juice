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
        }
        if (head == null) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 合并两个有序链表为一个新的有序链表。
     * @param node1
     * @param node2
     * @return
     */
    public ListNode mergeList(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        ListNode result;
        if (node1.getData() <= node2.getData()) {
            result = node1;
            result.setNext(mergeList(node1.getNext(), node2));
        } else {
            result = node2;
            result.setNext(mergeList(node2.getNext(), node1));
        }
        return result;
    }

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

    /**
     * 找到链表的倒数第n个结点
     * 使用一次链表扫描解决问题。
     * 使用两个指针pNthNode和pTemp。
     * 首先，两个指针都指向链表的头结点。仅当pTemp（沿着链表）进行了n次移动后，
     * pNthNode才开始移动。然后两个指针同时移动直至tTemp到达表尾。
     * 这时pNthNode指针所指的结点就是所求的结点，也就是链表的倒数第n个结点。
     * @param head
     * @param nthNode
     * @return
     */
    ListNode nthNodeFromEnd(ListNode head, int nthNode) {
        ListNode pTemp = head;
        ListNode pNnthNode = null;

        for (int count = 1; count < nthNode; count++) {
            if (pTemp != null) {
                pTemp = pTemp.getNext();
            }
        }

        while (pTemp != null) {
            if (pNnthNode == null) {
                pNnthNode = head;
            } else {
                pNnthNode = pNnthNode.getNext();
            }

            pTemp = pTemp.getNext();
        }
        if (pNnthNode != null) {
            return pNnthNode;
        }

        return null;
    }
}