package exam;

/**
 * 已知两个链表head1 和head2各自有序，请把他们合并成一个i依然有序的链表。
 * 结果链表要包含head1 和head2的所有结点，即结点值相同，
 * 
 * 使用递归的方式实现。
 * 具体步骤如下：
 * 1.比较链表的第一个结点数据，如果head1.data < head2.data，则把结果链表头结点指向链表head1中的第一个节点。
 * 2.对剩余的链表head1.next 和链表2（head2）再调用相同的方法，比较得到结果链表的第二个结点，添加到合并后列表的后面。
 * 3.一直递归调用步骤2，知道两个链表的结点都被加到结果链表中。
 * 
 * @author TurtusLi
 *
 */
class Node {
    Node next = null;
    int data;

    public Node(int data) {
	this.data = data;
    }
}

public class Example021 {

    public static Node mergeList(Node head1, Node head2) {
	if (null == head1) {
	    return head2;
	}

	if (null == head2) {
	    return head1;
	}

	Node head = null;

	if (head1.data < head2.data) {
	    head = head1;
	    head.next = mergeList(head1.next, head2);
	} else {
	    head = head2;
	    head.next = mergeList(head1, head2.next);
	}

	return head;
    }

    public static void main(String[] args) {
	Node head1 = new Node(1);
	Node node3 = new Node(3);
	head1.next = node3;

	Node node5 = new Node(5);
	node3.next = node5;

	node5.next = null;

	Node head2 = new Node(2);
	Node node4 = new Node(4);
	head2.next = node4;

	Node node6 = new Node(6);
	node4.next = node6;

	node6.next = null;

	Node mergeHead = mergeList(head1, head2);
	while (mergeHead != null) {
	    System.out.println(mergeHead.data);
	    mergeHead = mergeHead.next;
	}

    }

}
