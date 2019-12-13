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
            System.out.println("The position is not valid. The valid inputs are 1" + " to " + (size + 1));
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
}
