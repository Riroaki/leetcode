import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int len = A.length, sum = 0;
        boolean[] isEven = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (A[i] % 2 == 0) {
                isEven[i] = true;
                sum += A[i];
            } else isEven[i] = false;
        }
        int[] res = new int[queries.length];
        res[0] = sum;
        int count = 0;
        for (int[] pair : queries) {
            if (pair[0] == 0) {
                res[count++] = sum;
                continue;
            }
            int index = pair[1];
            if (isEven[index]) sum -= A[index];
            A[index] += pair[0];
            if (A[index] % 2 == 0) {
                isEven[index] = true;
                sum += A[index];
            } else isEven[index] = false;
            res[count++] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {5, 5, 4};
        int[][] q = {{0, 1}, {1, 0}, {4, 1}};
        System.out.println(Arrays.toString(new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(a, q)));
    }
}
