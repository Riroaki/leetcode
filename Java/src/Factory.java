public class Factory {
    public int factory(int x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        int sub = factory(x, n / 2);
        sub = (sub * sub) % 1000000007;
        return n % 2 == 1 ? x * sub % 1000000007 : sub;
    }

    public int factory2(int x, int n) {
        if (x == 0) return 0;
        int res = 1, base = x;
        while (n > 0) {
            if ((n & 1) == 1) res = res * base % 1000000007;
            n >>>= 1;
            base = (base * base) % 1000000007;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Factory().factory(12, 2));
        System.out.println(new Factory().factory2(13, 2));
    }
}
