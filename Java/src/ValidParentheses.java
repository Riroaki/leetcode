import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    // 注意两点就可以（一点误区，一点优化）
    public boolean isValid(String s) {
        if (s == null) return false;
        int n = s.length();
        if (n % 2 == 1) return false;// 1，这里需要注意长度为0是合法的
        Stack<Integer> stack = new Stack<>();
        Map<Character, Integer> symbolVal = Map.of(
                '{', 3,
                '}', -3,
                '[', 2,
                ']', -2,
                '(', 1,
                ')', -1
        );
        for (char c : s.toCharArray()) {
            int tmp = symbolVal.get(c);
            if (!stack.empty() && stack.peek() + tmp == 0) stack.pop();
            else if (tmp < 0) return false;
            else stack.push(tmp);
            // 2，优化：如果此时c是右括号，那么直接return false!
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("{[}]"));
        System.out.println(new ValidParentheses().isValid("{[]()}"));
        System.out.println(new ValidParentheses().isValid("{}"));
    }
}
