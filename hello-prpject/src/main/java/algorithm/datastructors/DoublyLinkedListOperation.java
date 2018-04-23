package algorithm.datastructors;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * Reverse the doubly linked list.
 * @author LiYanxue
 * @date 2018/4/21
 * @version 1.0
 */
public class DoublyLinkedListOperation {
    public static final String SEPARATOR = "->";

    /**
     * Traverse the doubly linked list.
     *
     * @param headNode the doubly linked list
     * @return the joined data of list
     */
    public static String traverse(DoublyLinkedList headNode) {
        List<Integer> data = new ArrayList<>();
        while (Objects.nonNull(headNode)) {
            data.add(headNode.getData());
            headNode = headNode.getNextNode();
        }

        return Joiner.on(SEPARATOR).join(data);
    } // end method traverse

    /**
     * Reverse the doubly linked list.
     *
     * @param headNode the doubly linked list
     * @return reversed doubly linked list
     */
    public static DoublyLinkedList reverse(DoublyLinkedList headNode) {
        DoublyLinkedList previous = null;
        DoublyLinkedList next;

        while (Objects.nonNull(headNode)) {
            next = headNode.getNextNode();
            headNode.setNextNode(previous);
            headNode.setPreviousNode(next);

            previous = headNode;
            headNode = next;
        }

        return previous;
    } // end method reverse

} // end class DoublyLinkedListOperation
