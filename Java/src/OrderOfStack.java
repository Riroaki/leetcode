public class OrderOfStack {
    public boolean isLegal(int[] nums) {
        int current = 0, index = 0, n = nums.length;
        Stack<Integer> stack = new Stack<>();
        while (index < n) {
            while (stack.isEmpty() || stack.peek() < nums[index]) {
                stack.push(current++);
                if (current == N)
                    break;
            }
            if (stack.peek() != nums[index])
                break;
            stack.pop();
            index++;
        }
        return stack.isEmpty();
    }
}
