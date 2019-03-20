public class Candy {
    // Naive version.
    // O(n^2) time, updating whenever the candy of a kid is incorrect.
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        int res = 0;
        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < n; i++) {
                if (i < n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    hasChanged = true;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    hasChanged = true;
                }
            }
        }
        for (int candy : candies)
            res += candy;
        return res;
    }

    // O(n) version.
    // Use 2 arrays.
    public int candy2(int[] ratings) {
        int n = ratings.length, res = 0;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        for (int i = n - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
        for (int i = 0; i < n; i++)
            res += Math.max(left[i], right[i]);
        return res;
    }

    // O(n)
    // Use 1 array, improvement of last solution.
    public int candy(int[] ratings) {
        int n = ratings.length, res = 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        // fill candies...
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        for (int i = n - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        for (int candy : candies)
            res += candy;
        return res;
    }
}
