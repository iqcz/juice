package algorithm.datastructors;

/**
 * Main method.
 * @author LiYanxue
 * @date 2018/4/21
 * @version 1.0
 */
public class Main {
    public static void main(String... args) {
        DoublyLinkedList doublyLinkedList = initList();

        System.out.printf("Traverse list: %s%n",
            DoublyLinkedListOperation.traverse(doublyLinkedList));

        DoublyLinkedList reversedList = DoublyLinkedListOperation.reverse(doublyLinkedList);

        System.out.printf("Reverse list: %s%n",
            DoublyLinkedListOperation.traverse(reversedList));
    } // end method main

    /**
     * initialize the doubly linked list.
     *
     * @return the head node
     */
    private static DoublyLinkedList initList() {
        DoublyLinkedList headNode = new DoublyLinkedList(1);
        DoublyLinkedList secondNode = new DoublyLinkedList(2);
        DoublyLinkedList thirdNode = new DoublyLinkedList(3);

        headNode.setPreviousNode(null);
        headNode.setNextNode(secondNode);

        secondNode.setPreviousNode(headNode);
        secondNode.setNextNode(thirdNode);

        thirdNode.setPreviousNode(secondNode);
        thirdNode.setNextNode(null);

        return headNode;
    } // end method initList

}
