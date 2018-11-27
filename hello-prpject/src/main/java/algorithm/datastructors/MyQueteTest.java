package algorithm.datastructors;

public class MyQueteTest {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        queue.insert(23);
        queue.insert(45);
        queue.insert(13);
        queue.insert(1);

        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

        System.out.println(queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove() + ", ");
        }
    }
}
