public class ScrambleString {
    // 其实这一个做法远比不上使用dp做的方法，但是由于leetcode的数据比较弱，所以时间上看起来是一样的；实际情况并非如此。
    // Another shorter version with same idea:
    /*
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;

        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;

        for (int i=1; i<s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
             && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
             && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }
     */

    // I thought that generating new substrings will cost extra time... but it turned out the time is the same.
    // However, the space comlpexity is better when doing so.
    // Time complexity: f(n) = 2n + 2sum(f(i) + f(n - i)) = 2n + 4sum(f(i)) < 2n + 4n * f(n - 1), so f(n) is O(n!).
    // Space complexity: I think it's close to O(n) as the stack depth is O(n) and the length is O(n) too.

    // Recursive version using divide and conquer.
    // Use a dict of 26 costs 2ms, beats 94%; whereas 128 costs 17ms, beating 14%.
    char[] ch1, ch2;
    int[] occur;
    
    public boolean isScramble(String s1, String s2) {
        ch1 = s1.toCharArray();
        ch2 = s2.toCharArray();
        occur = new int[26];
        return helper(0, s1.length(), 0, s2.length());
    }
    
    private boolean helper(int l1, int r1, int l2, int r2) {
        // Check whether the length is equal.
        if (r1 - l1 != r2 - l2)
            return false;
        // Check whether the length is 0.
        if (l2 == r2)
            return true;
        // Check whether the strings are equal.
        boolean equal = true;
        for (int i = l1, j = l2; i < r1; i++, j++) {
            if (ch1[i] != ch2[j]) {
                equal = false;
                break;
            }
        }
        if (equal)
            return true;
        // Check whether the letter counts are equal.
        Arrays.fill(occur, 0);
        for (int i = l1, j = l2; i < r1; i++, j++) {
            occur[ch1[i] - 'a']++;
            occur[ch2[j] - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (occur[i] != 0)
                return false;
        // I thought the length of left child should always be less or equal than
        // that of right child at first, but the case "abb" and "bab" shows that
        // the split could happen at ANY position of the string.
        for (int len = 1; len + l1 < r1; len++) {
            if ((helper(l1, l1 + len, l2, l2 + len)
                && helper(l1 + len, r1, l2 + len, r2))
            || (helper(l1, l1 + len, r2 - len, r2)
                && helper(l1 + len, r1, l2, r2 - len)))
                return true;
        }
        return false;
    }

    // dp version
    
}
