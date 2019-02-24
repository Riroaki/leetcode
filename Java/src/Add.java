import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Add {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            A[i] += K % 10 + carry;
            carry = A[i] / 10;
            A[i] %= 10;
            K /= 10;
            res.add(A[i]);
        }
        K += carry;
        while (K > 0) {
            res.add(K % 10);
            K /= 10;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Add().addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(new Add().addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(new Add().addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(new Add().addToArrayForm(new int[]{9, 9, 9, 9, 9}, 1));
        System.out.println(new Add().addToArrayForm(new int[]{}, 1));
    }
}
