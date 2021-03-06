package algorithm.datastructors;

/**
 * 循环链表基本操作
 *
 * @author i324779
 */
public class CLLNodeBasicOperation {

    /**
     * 计算循环链表的长度
     *
     * @param headNode
     * @return
     */
    int circulateListLength(CLLNode headNode) {
        int length = 0;
        CLLNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
            if (currentNode == headNode) {
                break;
            }

        }
        return length;
    }

    /**
     * 输出循环链表的内容
     *
     * @param headNode
     */
    void printCircularListData(CLLNode headNode) {
        CLLNode cllNode = headNode;
        while (cllNode != null) {
            System.out.println(cllNode.getData() + "->");
            cllNode = cllNode.getNext();
            if (cllNode == headNode) {
                break;
            }
        }
        System.out.println("(" + cllNode.getData() + ")headNode");
    }

    /**
     * 在循环链表末尾插入新结点
     *
     * @param headNode
     * @param nodeToInsert
     */
    void insertAtEndInList(CLLNode headNode, CLLNode nodeToInsert) {
        CLLNode currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        // 初始化其 next 指针指向该结点自身
        nodeToInsert.setNext(nodeToInsert);

        if (headNode == null) {
            headNode = nodeToInsert;
        } else {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
    }

    /**
     * 在循环链表的表头插入结点
     *
     * @param headNode
     * @param nodeToInsert
     */
    void insertAtBeginInCLL(CLLNode headNode, CLLNode nodeToInsert) {
        CLLNode currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null) {
            headNode = nodeToInsert;
        } else {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
            headNode = nodeToInsert;
        }
    }

    /**
     * 删除循环链表中的最后一个结点
     *
     * @param headNode
     */
    void deleteLastNode(CLLNode headNode) {
        CLLNode tmp = headNode;
        CLLNode currentNode = headNode;

        if (headNode == null) {
            System.out.println("Empty");
            return;
        }

        while (currentNode.getNext() != headNode) {
            tmp = currentNode;
            currentNode = currentNode.getNext();
        }

        tmp.setNext(headNode);
        currentNode = null;
    }

    /**
     * 删除循环链表中的第一个结点
     *
     * @param headNode
     */
    void deleteFirstNode(CLLNode headNode) {
        CLLNode tmp = headNode;
        CLLNode currentNode = headNode;

        if (headNode == null) {
            System.out.println("Empty");
            return;
        }

        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }

        currentNode.setNext(headNode.getNext());
        headNode = headNode.getNext();
    }

}
