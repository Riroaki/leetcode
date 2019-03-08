public class UniqueLetterString {
    // 对每个出现三次的字母（假设-1和n下标的字母也是S[i]，n为S长度）
    // 这样一来包含这个字母的字符串一共有：(i - prev) * (next - i)
    // 用一个map，list存下所有的字母出现的位置
    // 时间空间复杂度都是O(n)
    // 更好的策略比较难懂，这个是简单的思路
        // 此外，值得学习的地方还有：使用long作为结果，最后取一次mod
    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> index = new HashMap<>();
        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (!index.containsKey(s[i]))
                index.put(s[i], new ArrayList<>());
            index.get(s[i]).add(i);
        }
        long res = 0;
        for (List<Integer> A : index.values()) {
            A.add(0, -1);
            A.add(s.length);
            for (int i = 1; i < A.size() - 1; i++) {
                long a = A.get(i - 1), b = A.get(i), c = A.get(i + 1);
                res += (b - a) * (c - b);
            }
        }
        return (int)(res % 1_000_000_007);
    }
}
