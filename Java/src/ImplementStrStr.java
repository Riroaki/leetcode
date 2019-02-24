public class ImplementStrStr {
    // What should we return when needle is an empty string?
    // This is a great question to ask during an interview.
    // For the purpose of this problem, we will return 0 when needle is an empty string.
    // This is consistent to C's strStr() and Java's indexOf().
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        int nL = haystack.length(), nS = needle.length();
        if (nL < nS) return -1;
        if (nL == nS) return haystack.equals(needle) ? 0 : -1;
        int[] next = new int[nL];
        for (int start = 0; start < nL - nS; ) {
            boolean isEqual = true;
            for (int i = 0; i < nS; i++) {
                if (haystack.charAt(start + i) != needle.charAt(i)) {
                    start = next[start + i];
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) return start;
        }
        return -1;
    }
}
