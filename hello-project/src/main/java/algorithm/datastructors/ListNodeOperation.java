package algorithm.datastructors;

import java.util.Stack;

/**
 * 单链表的一些操作
 *
 * @author i324779
 */
public class ListNodeOperation {

    private int n;
    private int m;

    /**
     * 找到链表的中间节点
     * 使用两个指针。让第一个指针的移动速度是另一个的两倍。
     * 当第一个指针到达表尾时，另一个指针则指向中间节点。
     * Note：如果链表节点数为奇数，则第（n/2）个节点为中间节点。
     *
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
     *
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
     *
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
     *
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
     *
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
     *
     * 只用一次链表扫描解决该问题。
     * 还可以使用蛮力法，散列表等方式。
     *
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
        return pNnthNode;
    }

    /**
     * 给定两个有序单链表的头指针head1 和head2， 打印两个链表的公共部分。
     *
     * @param head1 有序链表1
     * @param head2 有序链表2
     */
    public void printCommonPart(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            System.out.println("Node is null");
            return;
        }

        System.out.println("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.getData() < head2.getData()) {
                head1 = head1.getNext();
            } else if (head1.getData() > head2.getData()) {
                head2 = head2.getNext();
            } else {
                System.out.println(head1.getData());
                head1 = head1.getNext();
                head2 = head2.getNext();
            }
        }
    }

    /**
     * 判断是否有环
     *
     * @param head 链表头结点
     * @return 是否有环
     */
    public static boolean isCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();

            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }

    /**
     * 逐对逆置链表
     *
     * @param head
     * @return
     */
    private void reversePairRecursive(ListNode head) {
        if (head == null || head.getNext() == null) {
            return;
        }

        ListNode cur = head.getNext();
        ListNode pre = head;
        ListNode next;

        while (cur != null && cur.getNext() != null) {
            next = cur.getNext().getNext();
            pre.setNext(cur.getNext());
            cur.getNext().setNext(cur);
            cur.setNext(next);
            pre = cur;
            cur = next;
        }

    }

    /**
     * 判断一个链表是否为回文结构
     *
     * @param head 单链表的头结点
     * @return true：回文结构；false：不是回文结构
     */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;

        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }

        while (head != null) {
            if (head.getData() != stack.pop().getData()) {
                return false;
            }
            head = head.getNext();
        }

        return true;
    }

    /**
     * 在有序链表中插入一个节点
     *
     * maybe have bug.
     * @param headNode
     * @param newNode
     * @return
     */
    ListNode insertInSortedList(ListNode headNode, ListNode newNode) {
        ListNode current = headNode;
        ListNode tmp = headNode;
        if (headNode == null) {
            return newNode;
        }

        // 遍历链表，直到找到比新结点中数据值更大的结点
        while (current != null && current.getData() < newNode.getData()) {
            tmp = current;
            current = current.getNext();
        }
        // 在该结点前插入新结点
        newNode.setNext(current);
        tmp.setNext(newNode);
        return headNode;
    }

    /**
     * 约瑟夫环
     * N 个人想选出一个领头人，他们排成一个环，沿着环每数到第 M 个人就从环中排除该人，
     * 并从下一个人开始重新数。找出最后留在环中的人。
     */
    ListNode getJosephusPosition(int n, int m) {
        ListNode p, q;
        // 建立一个包含所有人的循环链表
        p.setData(1);
        q = p;
        for (int i = 2; i < n; ++i) {
            p = p.getNext();
            p.setData(i);
        }
        p.setNext(q);

    }

    public static void main(String[] args) {
        ListNodeOperation operation = new ListNodeOperation();
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

        System.out.println("顺序输出：");
        for (cur = head.getNext(); cur != null; cur = cur.getNext()) {
            System.out.print(cur.getData() + " ");
        }

        operation.reversePairRecursive(head);

        System.out.println("\n逆序输出：");
        for (cur = head.getNext(); cur != null; cur = cur.getNext()) {
            System.out.print(cur.getData() + " ");
        }
    }
}
