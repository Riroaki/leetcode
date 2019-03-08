import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        helper(res, 0, n);
        return res;
    }
    
    private void helper(List<Integer> res, int curr, int n) {
        for (int i = 0; i < 10 && curr <= n; i++, curr++) {
            if (curr == 0)
                continue;
            res.add(curr);
            helper(res, curr * 10, n);
        }
    }
}
