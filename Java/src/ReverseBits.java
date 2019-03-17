public class ReverseBits {
    // To reverse a 32-bit integer,
        // we need to do 31 bit shifts and 32 adds;
        // so we should add n (1 bit left after 31 shifts) to res (32 bits left after 31 shifts)
        // after the 31-loop.
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 1; i < 32; i++) {
            res += n & 1;
            n >>>= 1;
            res <<= 1;
        }
        return res + n;
    }
}
