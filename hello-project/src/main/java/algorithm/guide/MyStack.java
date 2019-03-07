package algorithm.guide;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在栈的基础功能的基础上，再实现返回栈中最小元素的操作。
 */
public class MyStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum <= stackMin.peek()) {
            stackMin.push(newNum);
        }

        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        int value = stackData.pop();
        if (value == this.getMin()) {
            stackMin.pop();
        }
        return value;
    }

    private int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(7);
        myStack.push(2);
        myStack.push(1);

        System.out.println(myStack.pop());
        System.out.println(myStack.getMin());
    }
}
