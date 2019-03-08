import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    // sliding window
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> pos = new HashMap<>();
        int start = 0, n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pos.containsKey(c))
                start = Math.max(start, pos.get(c) + 1);
            pos.put(c, i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
