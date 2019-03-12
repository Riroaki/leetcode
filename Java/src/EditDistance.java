public class EditDistance {
    // 这题在NLP领域很有价值。在add、delete和swap的价值不同的时候就不能简化为O(n)的长度
        // 我们将问题转化为子问题。
        // 先考虑一个比较简单的情形，从a变到空字符串需要多少操作次数？自然就是a的长度，要么从a开始删除，要么从空字符串加到a
        // 我们设dp[i][j]表示s1的前i位到s2的前j位（i和j可以是0，最长位是长度）
        // 那么，我们有初始条件：dp[i][0] = i, dp[0][j] = j, 0 <= i <= n1, 0 <= j <= n2.
        // 递归条件：如果s1[i] == s2[j]，那么变化次数dp[i][j] = dp[i - 1][j - 1]
        // 如果s1[i] != s2[j]，那么我们有三种考虑：
            // 1，从s1的前i-1串到s2的前j串变化，要么s1加一位（加入s2的j位），要么s2减一位（即j位）；
            // 2，从s2的前j-1串到s1的前i串变化，要么s2加一位（加入s1的i位），要么s1减一位（即i位）；
            // 3，s1，s2各加一位。
        // 而我们就在这三者之间取最小的结果。
        // 最后结果为dp[n1][n2]
    
    // 这一题目的拓展：del，add，swap的权重不同，从a到b（注意，距离是对称的，但是这里不一定是对称的）
        // 那么有dp[0][0] = 0, dp[i][0] = w(del) + dp[i - 1][0], dp[0][i] = w(add) + dp[0][i - 1]
        // dp[i][j] = s1[i] == s2[j] ? dp[i - 1][j - 1] : min(dp[i - 1][j] + w(add), min(dp[i][j - 1] + w(del), dp[i - 1][j - 1] + w(swap))).
    // 这个题目让我想起了生物的碱基配对TACG。。。可以作为一个比较好的应用，用于检测基因变化！
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        int l1 = word1.length(), l2 = word2.length();
        int[][] dist = new int[l1 + 1][l2 + 1];
        // dist[i][j]表示的是word1.substring(0, i - 1)和word2.substring(0, j - 1)需要改变的次数
        // i,j表示截止的长度
        for (int i = 1; i <= l1; i++) dist[i][0] = i;
        for (int i = 1; i <= l2; i++) dist[0][i] = i;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dist[i][j] = dist[i - 1][j - 1];
                else dist[i][j] = 1 + Math.min(Math.min(dist[i][j - 1], dist[i - 1][j]), dist[i - 1][j - 1]);
            }
        }
        return dist[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse", "ros"));
        System.out.println(new EditDistance().minDistance("distance", "springbok"));
    }
}
