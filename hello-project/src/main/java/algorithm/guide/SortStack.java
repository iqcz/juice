package algorithm.guide;

import java.util.Stack;

/**
 * 将栈从栈顶到栈底按照从大到小的顺序排序。
 * 只允许申请一个栈。
 * @author i324779
 */
public class SortStack {

    public static void sortStackByStock(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();

            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(4);

        SortStack.sortStackByStock(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
