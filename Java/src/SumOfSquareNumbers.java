public class SumOfSquareNumbers {
    // O(n^0.5)
    // 双指针法，注意左右指针可以相等！
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)Math.sqrt(c) + 1;
        while (l <= r) {
            int tmp = l * l + r * r;
            if (tmp < c)
                l++;
            else if (tmp > c)
                r--;
            else
                return true;
        }
        return false;
    }

    // O(n^0.5)
    // map存平方，也是一个选择
    public boolean judgeSquareSum(int c) {
        Map<Integer, Integer> squares = new HashMap<>();
        int n = (int) Math.sqrt(c) + 1;
        for (int i = 0; i <= n; i++) {
            squares.put(i * i, i);
            if (squares.containsKey(c - i * i))
                return true;
        }
        return false;
    }
}
