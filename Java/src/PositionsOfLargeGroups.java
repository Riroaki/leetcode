import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0, end = 0;
        char[] s = S.toCharArray();
        for (int i = 1; i < s.length; i++) {
            if (s[i] != s[i - 1]) {
                end = i - 1;
                if (end - start > 1) {
                    List<Integer> tmp = Arrays.asList(start, end);
                    res.add(tmp);
                }
                start = i;
            }
        }
        end = s.length - 1;
        if (end - start > 1) {
            List<Integer> tmp = Arrays.asList(start, end);
            res.add(tmp);
        }
        return res;
    }
}
