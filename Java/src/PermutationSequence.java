import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] count = new int[n + 1];
        count[1] = 1;
        for (int i = 2; i <= n; i++) count[i] = count[i - 1] * i;
        if (k > count[n]) return "";
        k--;
        List<Integer> digits = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i > 0; i--) {
            int index = k / count[i];
            k %= count[i];
            res.append(digits.get(index));
            digits.remove(index);
        }
        res.append(digits.get(k));
        return res.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println(new PermutationSequence().getPermutation(2, i));
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(new PermutationSequence().getPermutation(3, i));
        }
        for (int i = 0; i < 24; i++) {
            System.out.println(new PermutationSequence().getPermutation(4, i));
        }
    }
}
