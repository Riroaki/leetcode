public class ComplementOf10BaseInteger {
    public int bitwiseComplement(int N) {
        String a = Integer.toBinaryString(N);
        int res = 0;
        for (int ch : a.toCharArray()) {
            res <<= 1;
            if (ch == '0')
                res += 1;
        }
        return res;
    }
}
