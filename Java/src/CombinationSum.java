import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // 7ms 100%，一次过
    private List<List<Integer>> helper(int[] candidates, int target, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (target < 0) return res;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(candidates[i]);
                res.add(tmp);
            } else if (candidates[i] < target) {
                List<List<Integer>> tmp = helper(candidates, target - candidates[i], i);
                if (tmp.size() > 0) {
                    for (List<Integer> vec : tmp) vec.add(candidates[i]);
                    res.addAll(tmp);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        return helper(candidates, target, 0);
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(
                new int[]{2, 3, 6, 7}, 7
        ));
    }
}
