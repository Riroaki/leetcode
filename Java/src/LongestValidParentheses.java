import java.util.Stack;

public class LongestValidParentheses {
    // naive解法，n2复杂度
    public int longestValidParenthesesNaive(String s) {
        if (s == null) return -1;
        if (s.length() == 0) return 0;
        int start = 0, res = 0, n = s.length();
        char[] str = s.toCharArray();
        while (start < n && str[start] == ')') start++;
        for (; start < n; start++) {
            int sum = 0;
            for (int i = start; i < n; i++) {
                if (str[i] == '(') sum++;
                else sum--;
                if (sum == 0) res = Math.max(res, i - start + 1);
                else if (sum < 0) break;
            }
        }
        return res;
    }

    // 7ms out of expectations...
    public int longestValidParenthesesOnline(String s) {
        if (s == null) return -1;
        if (s.length() == 0) return 0;
        char[] str = s.toCharArray();
        int sum = 0, res = 0, len = 0, n = s.length();
        // 从左到右遍历，遇到左括号+1，遇到右括号-1
        for (int i = 0; i < n; i++) {
            if (str[i] == '(') sum++;
            else sum--;
            if (sum < 0) {
                sum = 0;
                len = 0;
            } else {
                len++;
                if (sum == 0) res = Math.max(res, len);
            }
        }
        // 从右到左遍历，遇到右括号+1，遇到左括号-1
        sum = 0;
        len = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str[i] == ')') sum++;
            else sum--;
            if (sum < 0) {
                sum = 0;
                len = 0;
            } else {
                len++;
                if (sum == 0) res = Math.max(res, len);
            }
        }
        return res;
    }

    // 13ms
    // 使用栈。遍历一遍s，将左括号和右括号的下标压入栈，如果遇到匹配就弹出。
    // 这样一来栈内剩下的只有不匹配的序号了。如果栈是空的说明s整个都是合法的；
    // 否则，比较被非法字符分割的部分长度，取出最长的一段的长度
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int res, start = 0, n = s.length();
        char[] str = s.toCharArray();
        Stack<Integer> indices = new Stack<>();
        for (; start < n; start++) {
            if (str[start] == '(') indices.push(start);
            else {
                if (indices.isEmpty()) indices.push(start);
                else if (str[indices.peek()] == '(') indices.pop();
                else indices.push(start);
            }
        }
        if (indices.isEmpty()) return n;
        start = indices.pop();
        res = n - 1 - start;
        while (!indices.isEmpty()) {
            int tmp = indices.pop();
            res = Math.max(res, start - tmp - 1);
            start = tmp;
        }
        res = Math.max(res, start);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParenthesesOnline("(()"));
        System.out.println(new LongestValidParentheses().longestValidParenthesesOnline("())"));
        System.out.println(new LongestValidParentheses().longestValidParenthesesOnline(""));
        System.out.println(new LongestValidParentheses().longestValidParenthesesOnline("())()"));
        System.out.println(new LongestValidParentheses().longestValidParenthesesOnline(")()())"));
    }
}
