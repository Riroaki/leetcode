public class BestTimetoBuyAndSellStock3 {
    // 太玄了这个算法，而且是在线的。。
    // 这个算法字面上就可以理解了，每遇到一天，就是在这一天的基础上假设
    // buy1保留的是这一天已经买了和在之前买所剩金额（是0或者负数）最优解；
    // sell1保留的是这一天卖出和之前卖出后所剩金额（即第一次买卖的收益）的最优解；
    // buy2保留的是这一天第二次买和之前第二次买后所剩金额的最优解；
    // sell2保留的是这一天第二次卖出和之前第二次卖出后收益的最优解。

    // 注意：
    // 以上四个值并非绝对。比如第二次交易未必会进行，此时sell2=sell1；
    // 最后结果一定能给出最优解但是未必经历了正常的流程。
    // 比如在这里的例子中，3， 3， 5， 0， 0， 0， 3， 1， 4， 6
    // 按照这个算法得到的解是buy1=0，sell1=4，buy2=2，sell2=6，
    // 也就是说，在第3/4天买入0，在7天卖出4；然后在7天买入4后，在8天卖出6，收益4+2=6。
    // 而正常的思路是，在3/4天买入0，在5天卖出3；然后在6天买入1后，在8天卖出4，收益3+3=6。
    // 结果一样，含义不同。
    public int maxProfitBest(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            // buy1更新了，不会影响sell1：因为此时buy1+price=0
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
//            System.out.println(price + "\t" + buy1 + "," + sell1 + "," + buy2 + "," + sell2);
        }
        return sell2;
    }

    // DP solution for k-transactions.
    // 推荐这一方案，采用了dp，对k次买卖进行计算最优
    public int maxProfitDP(int[] prices) {
        return maxProfit(2, prices);
    }

    // f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions.
    // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
    //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
    // f[0, ii] = 0; 0 times transation makes 0 profit
    // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
    private int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        else {
            int maxProf = 0;
            int[][] f = new int[k + 1][prices.length];
            for (int kk = 1; kk <= k; kk++) {
                int tmpMax = f[kk - 1][0] - prices[0];
                for (int ii = 1; ii < prices.length; ii++) {
                    f[kk][ii] = Math.max(f[kk][ii - 1], prices[ii] + tmpMax);
                    tmpMax = Math.max(tmpMax, f[kk - 1][ii] - prices[ii]);
                    maxProf = Math.max(f[kk][ii], maxProf);
                }
            }
            return maxProf;
        }
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyAndSellStock3().maxProfitDP(
                new int[]{3, 3, 5, 0, 0, 3, 1, 4}
        ));
    }
}
