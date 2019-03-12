public class ScoreOfParentheses {
    private char[] ch;

    private int helper(int from, int to) {
        int index = from, count, end, res = 0;
        while (index < to) {
            end = index + 1;
            count = 1;
            while (end < to && count != 0)
                count += ch[end++] == '(' ? 1 : -1;
            res += end - index == 2 ? 1 : helper(index + 1, end - 1) * 2;
            index = end;
        }
        return res;
    }

    public int scoreOfParentheses(String s) {
        if (s.length() == 0)
            return 0;
        ch = s.toCharArray();
        return helper(0, ch.length);
    }
}
