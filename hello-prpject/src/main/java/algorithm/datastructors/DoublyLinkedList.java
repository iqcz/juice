package algorithm.datastructors;

/**
 * Doubly Linked List entity.
 *
 * @author LiYanxue
 * @date 2018/4/21
 * @version 1.0
 */
public class DoublyLinkedList {

    private int data;
    private DoublyLinkedList previousNode;
    private DoublyLinkedList nextNode;

    public DoublyLinkedList() {

    }

    public DoublyLinkedList(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }


    public DoublyLinkedList getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoublyLinkedList previousNode) {
        this.previousNode = previousNode;
    }

    public DoublyLinkedList getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyLinkedList nextNode) {
        this.nextNode = nextNode;
    }

} // end class DoublyLinkedList
