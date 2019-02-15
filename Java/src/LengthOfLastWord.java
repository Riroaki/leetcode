public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)return 0;
        for(int i=s.length()-1;i>=0;i--)
            if(s.charAt(i) != ' ') {
                int j=i;
                while(j>=0 && s.charAt(j) != ' ')j--;
                return i - j;
            }
        return 0;
    }
}
