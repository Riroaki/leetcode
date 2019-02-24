import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows < 1) return res;
        List<Integer> last = new ArrayList<>();
        last.add(1);
        res.add(last);
        for(int i=2;i<=numRows;i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if(last.size()>1) {
                int left = last.get(0), right = last.get(1);
                row.add(left + right);
                for(int j=2;j<=last.size() - 1;j++) {
                    left = right;
                    right = last.get(j);
                    row.add(left + right);
                }
            }
            row.add(1);
            res.add(row);
            last = row;
        }
        return res;
    }
}
