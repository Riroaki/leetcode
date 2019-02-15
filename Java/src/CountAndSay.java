public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int count = 1;
                while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                    j++;
                }
                sb.append(count);
                sb.append(s.charAt(j));
            }
            s = sb.toString();
            // System.out.println(s);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }
}
