public class FindAllAnagramsInString {
    // sliding window, 7ms 97%
    // same as permutation in string
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n1 = s.length(), n2 = p.length();
        if (n1 < n2)
            return res;
        int[] freq = new int[128], curr = new int[128];
        for (int i = 0; i < n2; i++) {
            freq[p.charAt(i)]++;
            curr[s.charAt(i)]++;
        }
        int diff = 0;
        for (int i = 0; i < 128; i++)
            diff += freq[i] != curr[i] ? 1 : 0;
        int start = 0;
        for (int end = start + n2; end < n1; end++, start++) {
            if (diff == 0)
                res.add(start);
            int si = s.charAt(start), ei = s.charAt(end);
            curr[si]--;
            if (curr[si] == freq[si])
                diff--;
            else if (curr[si] + 1 == freq[si])
                diff++;
            curr[ei]++;
            if (curr[ei] == freq[ei])
                diff--;
            else if (curr[ei] - 1 == freq[ei])
                diff++;
        }
        if (diff == 0)
            res.add(start);
        return res;
    }
}
