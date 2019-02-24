public class EditDistance {
    // 神人啊，巧妙简洁的思路
    // https://leetcode.com/problems/edit-distance/discuss/237164/Java-Dynamic-programming-with-explaination
    //First of all, the word1 and word2 are symetric in that the min number of steps to change from word1 to word2 is the same from word2 to word1, so the choice which one is column and which one is row is random.
    //Create a 2D array dp with word1.length() + 1 and word2.length() + 1, the +1's are meant for empty strings.
    //Each cell in the dp[i][j] means the minimal steps transforming from word1.substring(0, i) to word2.substring(0, j);
    //Initialize dp[0][0] with 0, because it takes no change from empty string to empty string.
    //For zero column, zero row, the values increases with the index because you have to remove k characters to transform a string of k length into an empty string.
    //For the remaining cells, if the column character i (word1.charAt(i)) and row character j (word2.charAt(j)) are the same, no change is needed, take the number of changes from the previous step ([i-1][j-1]);
    //If the characters are different, that means we have to either
        //change a character (dp[i - 1][j -1])
        //remove a character from word1 dp[i-1][j], or insert one in word2
        //remove a character from word2 d[i][j-1], or insert one in word1
    //In these cases, the extra change is one, and we only need to use the min of the three.
    //When we get to the end, we will have the number of changes that is needed for changing word1 to word2.
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int l1 = word1.length(), l2 = word2.length();
        int[][] dist = new int[l1 + 1][l2 + 1];
        // dist[i][j]表示的是word1.substring(0, i - 1)和word2.substring(0, j - 1)需要改变的次数
        // i,j表示截止的长度
        for (int i = 1; i <= l1; i++) dist[i][0] = i;
        for (int i = 1; i <= l2; i++) dist[0][i] = i;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dist[i][j] = dist[i - 1][j - 1];
                else dist[i][j] = 1 + Math.min(Math.min(dist[i][j - 1], dist[i - 1][j]), dist[i - 1][j - 1]);
            }
        }
        return dist[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse", "ros"));
        System.out.println(new EditDistance().minDistance("distance", "springbok"));
    }
}
