public class RegularExpressionMatching {
    private boolean charMatch(char s, char p) {
        return s == p || p == '.';
    }

    public boolean isMatch(String s, String p) {
        int star = p.indexOf("*"), n1 = s.length(), n2 = p.length();
        if (star == 0)
            return false;
        if (star < 0) {
            // simple match.
            if (n1 != n2)
                return false;
            for (int i = 0; i < n1; i++)
                if (!charMatch(s.charAt(i), p.charAt(i)))
                    return false;
            return true;
        } else {
            // simple match the chars before star - 1
            if (n1 < star - 1 || !isMatch(s.substring(0, star - 1), p.substring(0, star - 1)))
                return false;
            // 从s中取0位到n位，和p的含*的两个位进行匹配，同时将后面部分和s的star+1起的字符串匹配
            int i = star - 1;
            String after = p.substring(star + 1);
            char repeat = p.charAt(star - 1);
            for (; i < n1 && charMatch(s.charAt(i), repeat); i++)
                if (isMatch(s.substring(i), after))
                    return true;
            // 上面的匹配还剩下最后一次，也就是在0～i-1部分都可以匹配p[star - 1]的时候，从i开始的匹配
            return isMatch(s.substring(i), after);
        }
    }
}
