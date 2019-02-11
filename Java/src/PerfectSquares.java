import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    // Still needs improving...
    private List<Integer> squares = new ArrayList<>();
    private int[] minSquareCount;

    private int findSquare(int num) {
        if (num == 0) return 0;
        int min = num;
        for (Integer square : squares) {
            if (square > num) break;
            int remain = num - square;
            int tmp = minSquareCount[remain] > 0 ? minSquareCount[remain] : findSquare(remain);
            min = Math.min(min, tmp + 1);
        }
        return minSquareCount[num] = min;
    }

    public int numSquares(int n) {
        minSquareCount = new int[n + 1];
        minSquareCount[1] = 1;
        squares.add(1);
        int i = 2;
        while (squares.get(i - 2) < n) {
            squares.add(i * i);
            i++;
        }
        return findSquare(n);
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(4));
        System.out.println(new PerfectSquares().numSquares(12));
        System.out.println(new PerfectSquares().numSquares(13));
    }
}
