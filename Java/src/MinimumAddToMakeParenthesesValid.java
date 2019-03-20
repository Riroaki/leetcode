public class MinimumAddToMakeParenthesesValid {
    // 1. 每次遇到多余的右括号就加1
    // 2. 注意结果不能忘记加count，它表示当前多余左括号的个数
    public int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length(), res = 0, count = 0;
        for (char c : s.toCharArray()) {
            count += c == '(' ? 1 : -1;
            if (c == -1) {
                res++;
                c = 0;
            }
        }
        return res + count;
    }
}
