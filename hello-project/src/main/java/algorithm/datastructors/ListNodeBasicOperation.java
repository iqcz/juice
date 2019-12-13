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

    ListNode insertList(ListNode headNode, ListNode nodeToInsert, int position) {
        // 若链表为空，插入新结点
        if (headNode == null) {
            return nodeToInsert;
        }
        int size = listLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
        }

        // 在链表开头插入
        if (position == 1) {
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            // 在中间或是末尾插入
            ListNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode.getNext());
            previousNode.setNext(nodeToInsert);
        }

        return headNode;
    }

    ListNode deleteNodeFromList(ListNode headNode, int position) {
        int size = listLength(headNode);
        if (position > size || position < 1) {
            System.out.println("Position of node to delete is invalid. The valid inpusts are 1 " + "to" + size);
            return headNode;
        }

        // 删除单向链表的表头结点
        if (position == 1) {
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        } else {
            ListNode previousNode = headNode.getNext();
            int count = 1;
            while (count < position) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }

        return headNode;
    }

    /**
     *  将当前结点保存在临时变量中，然后释放当前结点。
     *  释放完当前结点后，移动到下一个结点并将其保存在临时变量中，
     *  然后不断重复该过程直到释放所有结点。
     * @param headNode
     */
    public void deleteList(ListNode headNode) {
        ListNode auxilaryNode;
        ListNode iterator = headNode;
        while (iterator != null) {
            auxilaryNode = iterator.getNext();
            iterator = null;
            iterator = auxilaryNode;
        }

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
