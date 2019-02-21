import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;
        for (int i = 0; i < amount; i++) {
            for (int coin : coins) {
                if (minCoins[i] != Integer.MAX_VALUE && i + coin <= amount && i + coin > i)
                    minCoins[i + coin] = Math.min(minCoins[i] + 1, minCoins[i + coin]);
            }
        }
        return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
        System.out.println(new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(new CoinChange().coinChange(new int[]{1, 2147483647}, 2));
    }
}
