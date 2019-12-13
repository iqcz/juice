package algorithm.datastructors;

/**
 * 双向链表基本操作
 *
 * @author i324779
 */
public class DoublyLinkedListBasicOperation {

    static int listLength(DoublyLinkedList head) {
        int length = 0;
        DoublyLinkedList currentNode = head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNextNode();
        }

        return length;
    }

    DoublyLinkedList insertDoubleLinkedList(DoublyLinkedList headNode, DoublyLinkedList nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }
        int size = listLength(headNode);

        if (position > size + 1 || position < 1) {
            System.out.println("The position is not valid. The valid inputs are 1 to " + (size + 1));
            return headNode;
        }

        // 在链表开头插入
        if (position == 1) {
            nodeToInsert.setNextNode(headNode);
            headNode.setPreviousNode(nodeToInsert);
            return nodeToInsert;
        } else {
            // 在链表中间或末尾插入
            DoublyLinkedList previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNextNode();
                count++;
            }
            DoublyLinkedList currentNode = previousNode.getNextNode();
            nodeToInsert.setNextNode(currentNode);
            if (currentNode != null) {
                currentNode.setPreviousNode(nodeToInsert);
            }
            previousNode.setNextNode(nodeToInsert);
            nodeToInsert.setPreviousNode(previousNode);
        }

        return headNode;
    }

    DoublyLinkedList deleteNodeFromList(DoublyLinkedList headNode, int position) {
        int size = listLength(headNode);

        if (position > size || position < 1) {
            System.out.println("Position of node to delete is invalid. The valid inputs are 1 to " + size);
        }

        // 删除双向链表第一个结点
        if (position == 1) {
            DoublyLinkedList currentNode = headNode.getNextNode();
            currentNode.setPreviousNode(null);
            headNode = null;
            return currentNode;
        } else {
            // 删除中间或末尾结点
            DoublyLinkedList previousNode = headNode;
            int count = 1;
            while (count < position) {
                previousNode = previousNode.getNextNode();
                count++;
            }
            DoublyLinkedList currentNode = previousNode.getNextNode();
            DoublyLinkedList laterNode = currentNode.getNextNode();

            previousNode.setNextNode(laterNode);
            if (laterNode != null) {
                // 如果被删除结点的后继结点不是 null 结点，
                // 那么设置其前驱结点指针指向被删除结点的前驱结点
                laterNode.setPreviousNode(previousNode);
            }
            currentNode = null;
        }

        return headNode;
    }
}
