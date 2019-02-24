public class BestTimetoBuyAndSellStock2 {
    // 无限次交易，那么答案很简单：
    // 因为首先股票的价格变化是以天为单位变化的，
    // 不论是连续的上升还是间断的上升，我只需取每一小段，累加起来都是一样的
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int res = 0;
        for (int i = 0; i < n - 1; i++)
            res += Math.max(0, prices[i + 1] - prices[i]);
        return res;
    }
}
