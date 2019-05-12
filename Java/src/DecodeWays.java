public class DecodeWays {
    // simple dp. 1ms
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] count = new int[n];
        count[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0')
                count[i] = 0;
            else {
                count[i] = count[i + 1];
                if (s.charAt(i) == '1'
                    || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                    count[i] += i + 2 < n ? count[i + 2] : 1;
            }
        }
        return count[0];
    }
}
