import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] res;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if (carry == 0)
            res = digits.clone();
        else {
            res = new int[digits.length + 1];
            res[0] = carry;
            System.arraycopy(digits, 0, res, 1, res.length - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{2, 3, 9})));
    }
}
