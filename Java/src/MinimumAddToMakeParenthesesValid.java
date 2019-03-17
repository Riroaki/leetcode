public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length(), res = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                while (i < n && s.charAt(i) == ')') {
                    i++;
                    res++;
                }
            }
            if (i < n)
                count += s.charAt(i) == '(' ? 1 : -1;
        }
        return res + count;
    }
}
