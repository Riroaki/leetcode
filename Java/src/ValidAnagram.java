public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if (n1 != n2)
            return false;
        int[] freq = new int[128];
        for (int i = 0; i < n1; i++) {
            freq[s.charAt(i)]++;
            freq[t.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++)
            if (freq[i] != 0)
                return false;
        return true;
    }
}
