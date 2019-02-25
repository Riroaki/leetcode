import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MostProfitAssigningWork {
    // zip profit and difficulty, sort them, and sort the worker
    // finally get the result by scanning it.
    public int maxProfitAssignmentNaive(int[] difficulty, int[] profit, int[] worker) {
        int n = worker.length, m = difficulty.length, res = 0, currentBest = 0;
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < m; i++) tmp.add(new int[]{difficulty[i], profit[i]});
        tmp.sort(Comparator.comparingInt(o -> o[0]));
        Arrays.sort(worker);
        for (int i1 : worker) {
            for (int j = currentBest; j < m && tmp.get(j)[0] <= i1; j++)
                if (tmp.get(j)[1] >= tmp.get(currentBest)[1]) currentBest = j;
            if (tmp.get(currentBest)[0] <= i1)
                res += tmp.get(currentBest)[1];
        }
        return res;
    }

    // bucket sort.
    // 7ms 100%
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = 100000, res = 0, max = 0, m=difficulty.length;
        int[] bucket = new int[n + 1];
        for (int i = 0; i < m; i++) {
            // 这一步是避免存在难度相同但是利润不同的结果，当然是保存利润最大的那一个
            if(bucket[difficulty[i]] < profit[i])
                bucket[difficulty[i]] = profit[i];
        }
        // 找到在某个难度以内最大的profit
        for (int i = 0; i <= n; i++) {
            if (bucket[i] > max) max = bucket[i];
            else bucket[i] = max;
        }
        for (int num : worker) res += bucket[num];
        return res;
    }
}
