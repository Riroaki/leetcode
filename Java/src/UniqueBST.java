public class UniqueBST {
    // 精妙的思路。
    // 对每个树，我们可以看作是一个root，和它的左右子树。
    // 求一个节点数为n的树有几种（求f(n)），就是求这样的组合：m1 + 1 + m2 = n
    // 其中m1和m2代表左右子树的节点数。
    // 那么，对于每一种m1和m2的组合，一共有f(m1)*f(m2)的种类。
    // 使用memo法求解即可。
    public int numTrees(int n) {
        if (n <= 0) return 0;
        int[] res = new int[n + 1];
        res[0] = res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) res[i] += res[j] * res[i - 1 - j];
        }
        return res[n];
    }
}
