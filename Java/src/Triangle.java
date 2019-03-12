import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> tri) {
        if (tri.isEmpty())
            return 0;
        int row = tri.size(), col = tri.get(row - 1).size();
        int[] prev = new int[col], curr = new int[col];
        curr[0] = tri.get(0).get(0);
        for (int i = 1; i < row; i++) {
            int[] tmp = curr;
            curr = prev;
            prev = tmp;
            curr[0] = prev[0] + tri.get(i).get(0);
            for (int j = 1; j < i; j++)
                curr[j] = Math.min(prev[j - 1], prev[j]) + tri.get(i).get(j);
            curr[i] = prev[i - 1] + tri.get(i).get(i);
        }
        int res = Integer.MAX_VALUE;
        for (int num : curr)
            res = Math.min(res, num);
        return res;
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
