public class PalindromeNumber {
    public boolean isPalindromeNaive(int x) {
        String a = Integer.toString(x);
        for (int i = 0, j = a.length() - 1; i < j; i++, j--)
            if (a.charAt(i) != a.charAt(j)) return false;
        return true;
    }

    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int reverseX = 0, copyX = x;
        while(x!=0) {
            reverseX = reverseX * 10 + x % 10;
            x /= 10;
        }
        return reverseX == copyX;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(-121));
    }
}
