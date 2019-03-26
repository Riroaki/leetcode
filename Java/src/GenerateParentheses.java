import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> res;
    char[] word;
    int bound;

    public List<String> generateParentheses(int n) {
        bound = n;
        word = new char[n << 1];
        res = new ArrayList<>();
        helper(0, 0);
        return res;
    }

    private void helper(int left, int right) {
        if (left == bound && right == bound) {
            res.add(String.valueOf(word));
            return;
        }
        if (left < bound) {
            word[left + right] = '(';
            helper(left + 1, right);
        }
        if (right < bound && right < left) {
            word[left + right] = ')';
            helper(left, right + 1);
        }
    }
}
