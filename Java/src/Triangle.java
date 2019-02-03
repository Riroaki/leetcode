import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        if (height == 0) return 0;
        // dp[i] means the minimum path to get triangle[level][i]
        int[] dp = new int[height];
        dp[0] = triangle.get(0).get(0);
        for (int level = 1; level < height; level++) {
            // The first element is only available to the first element on last level.
            dp[0] += triangle.get(level).get(0);
            for (int j = 1; j < level; j++) {
                if (dp[j] <= dp[j - 1]) dp[j] += triangle.get(level).get(j);
                else dp[j] = dp[j - 1] + triangle.get(level).get(j);
            }
            // The last element is only available to the last element on last level.
            dp[level] = dp[level - 1] + triangle.get(level).get(level);
        }
        int min = dp[0];
        for (int j = 1; j < height; j++)
            if (min > dp[j])
                min = dp[j];
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> tmp = new ArrayList<>();
        tmp.add(new ArrayList<>(Collections.singletonList(2)));
        tmp.add(new ArrayList<>(Arrays.asList(3, 4)));
        tmp.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        tmp.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(new Triangle().minimumTotal(tmp));
    }
}
