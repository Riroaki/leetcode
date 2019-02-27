import java.util.Arrays;

public class DistinctSubsequencesII {
    // solution
    // 基本上，每次加入一个字母，个数都会翻倍，
    // 因为每加入一个字母都多了一倍的可能：之前的字符串加上/不加上这个字母。
    // 新的可能就是在之前的字符后面加入这个新字符带来的，所以考虑这部分和原来的部分有没有重复就可以了。

    // 比如，abcded，刚加入d的时候，可能性为8（abc的8种可能）*2，而加入第二个d的时候，
    // 因为当不包含de而包含abc的时候才会出现重复，而且重复的就是含abc且以d结尾的字符串。
    // 所以这里的重复可能性就是上一次重复出现位置前一个的总数，而且是上一个出现
    public int distinctSubseqII(String S) {
        int MOD = 1_000_000_007;
        int n = S.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 2; i < n; i++) {
            int c = S.charAt(i) - 'a';
            dp[i] = dp[i - 1] * 2 % MOD;
            if (last[c] != -1)
                dp[i] = dp[i] - dp[last[c] - 1] % MOD;
        }
        dp[n]--;
        if (dp[n] < 0)
            dp[n] += MOD;
        return dp[n];
    }
}
