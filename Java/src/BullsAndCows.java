public class BullsAndCows {
    public String getHintNaive(String secret, String guess) {
        int correct = 0; // the bulls
        int misplace = 0; // the cows
        int[] exist = new int[10];
        for (char c : secret.toCharArray())
            exist[c - '0']++;
        // 优先检测完全匹配，其次再检测不匹配但是存在的数
        for (int i = 0, j = guess.length(); i < j; i++) {
            int num = guess.charAt(i) - '0';
            if (secret.charAt(i) - '0' == num) {
                correct++;
                exist[num]--;
            }
        }
        // 看看不匹配的数是否有错位
        for (int i = 0, j = guess.length(); i < j; i++) {
            int num = guess.charAt(i) - '0';
            if (secret.charAt(i) - '0' != num && exist[num] > 0) {
                misplace++;
                exist[num]--;
            }
        }
        return correct + "A" + misplace + "B";
    }

    public String getHint(String secret, String guess) {
        int correct = 0; // the bulls
        int total = 0; // the cows and the bulls
        int[] exist = new int[10];
        for (char c : secret.toCharArray())
            exist[c - '0']++;
        // 通过检测是否出现在数组中，可以获得bulls和cows的和
        for (int i = 0, j = secret.length(); i < j; i++) {
            if (secret.charAt(i) == guess.charAt(i)) correct++;
            if (exist[guess.charAt(i) - '0']-- > 0) total++;
        }
        return correct + "A" + (total - correct) + "B";
    }

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("", ""));
        System.out.println(new BullsAndCows().getHint("1807", "7810"));
        System.out.println(new BullsAndCows().getHint("1123", "0111"));
        System.out.println(new BullsAndCows().getHint("1122", "1222"));
    }
}
