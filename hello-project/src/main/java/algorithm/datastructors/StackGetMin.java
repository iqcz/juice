package algorithm.datastructors;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，
 * 再实现返回栈中最小元素的操作。
 *
 * @author i324779
 */
public class StackGetMin {
    private final Stack<Integer> stackData; // 正常栈
    private final Stack<Integer> stackMin; // 保存每一步最小值的栈

    public StackGetMin() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }

        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }

        return value;
    }

    private int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        return this.stackMin.peek();
    }
}
