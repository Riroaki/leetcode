import java.util.PriorityQueue;
import java.util.Stack;

class MinStackNaive {
    /**
     * initialize your data structure here.
     */
    private PriorityQueue<Integer> orderedNums = new PriorityQueue<>();
    private Stack<Integer> nums = new Stack<>();

    public MinStackNaive() {
    }

    public void push(int x) {
        nums.push(x);
        orderedNums.offer(x);
    }

    public void pop() {
        int x = nums.pop();
        orderedNums.remove(x);
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return orderedNums.peek();
    }
}

public class MinStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        // 这里写的必须是x<=min而不是小于，因为可能出现一个最小值被压入栈n次的情形。
        // 而如果压入n次，后面的最小值被弹出之后会误把上一个数当作min，而在这个最小值被压入前的最小值并不是那个数
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
