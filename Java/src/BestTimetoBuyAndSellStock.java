public class BestTimetoBuyAndSellStock {
    // 只能交易一次，那么遍历过程中带着最小值进行比较，保留最大的差额

    // 这个思路是遍历三遍，对每一个位置取一个左侧最小值和右侧最大值。。。其实没有必要
    /*
    public int maxProfitNaive(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[] minFromLeft = new int[n], maxFromRight = new int[n];
        minFromLeft[0] = prices[0];
        maxFromRight[n - 1] = prices[n - 1];
        for (int i = 1; i < n; i++) {
            minFromLeft[i] = Math.min(prices[i], minFromLeft[i - 1]);
            maxFromRight[n - 1 - i] = Math.max(prices[n - 1 - i], maxFromRight[n - i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, maxFromRight[i] - minFromLeft[i]);
        return res;
    }
    */

    // 这个是遍历一遍，保存从左往右的最小值，时刻更新和比较
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int minFromLeft = prices[0], res = 0;
        for (int price : prices) {
            if (price > minFromLeft) res = Math.max(res, price - minFromLeft);
            else minFromLeft = price;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
