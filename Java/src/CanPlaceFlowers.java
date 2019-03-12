public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] f, int n) {
        int nf = f.length;
        for (int i = 0; i < nf; i++) {
            if (f[i] == 0 && (i == 0 || f[i - 1] == 0) && (i == n - 1 || f[i + 1] == 0)) {
                n--;
                i++;// 这样会快点因为这里种了花那下一个肯定种不了
            }
        }
        return n >= 0;
    }
}
