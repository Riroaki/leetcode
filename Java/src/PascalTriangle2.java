import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
    // Quickest solution, but need more space.
    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex + 1];
        Arrays.fill(row, 1);
        for (int i = 2; i <= rowIndex; ++i) {
            for (int j = 1; j <= i / 2; ++j) row[j] = row[i - j] + row[j];
            for (int j = i / 2; j > 0; --j) row[i - j] = row[j];
        }
        final List<Integer> result = new ArrayList<>(row.length);
        for (int num : row) result.add(num);
        return result;
    }

    // 1ms, 91.42% of java
    public List<Integer> getRowNaive(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex);
        res.add(1);
        if (rowIndex >= 1)
            res.add(1);
        for (int i = 1; i < rowIndex; i++) {
            res.add(1);
            for (int j = i; j > 0; j--)
                res.set(j, res.get(j) + res.get(j - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle2().getRow(0));
        System.out.println(new PascalTriangle2().getRow(1));
        System.out.println(new PascalTriangle2().getRow(2));
        System.out.println(new PascalTriangle2().getRow(3));
    }
}
