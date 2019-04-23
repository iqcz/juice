package algorithm.datastructors;

import java.util.Stack;

/**
 * 用两个栈实现队列，支持队列的基本操作（add，Poll，peek）
 *
 * @author i324779
 */
public class TwoStacksQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * 把push栈向pop栈倒入数据
     */
    private void pushToPop() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
        this.pushToPop();
    }

    public int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty.");
        }

        this.pushToPop();
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty.");
        }

        this.pushToPop();
        return stackPop.peek();
    }

}
