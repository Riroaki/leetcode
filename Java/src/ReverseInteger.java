public class ReverseInteger {
    public int reverseNaive(int x) {
        int res = 0;
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        int last;
        while (x != 0) {
            last = res;
            res *= 10;
            res += x % 10;
            x /= 10;
            if (res / 10 != last) return 0;// 中间可能溢出，这里也可以采用res > 217... || res < -217...判断是否溢出
        }
        res *= isNegative ? -1 : 1;
        if (isNegative && res > 0 || !isNegative && res < 0) return 0;
        return res;
    }

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
        System.out.println(new ReverseInteger().reverse(Integer.MAX_VALUE));
        System.out.println(new ReverseInteger().reverse(Integer.MIN_VALUE));
    }
}
