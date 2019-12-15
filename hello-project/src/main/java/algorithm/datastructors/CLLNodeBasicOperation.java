package algorithm.datastructors;

/**
 * 循环链表基本操作
 *
 * @author i324779
 */
public class CLLNodeBasicOperation {

    /**
     * 计算循环链表的长度
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
}
