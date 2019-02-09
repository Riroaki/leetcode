import java.util.List;

public class ShortestWordDistance {
    // 最naive的初步做法是，遍历两遍数组并将所有出现的位置存在两个list中，然后两个list两两比较
    // 进阶版本：遍历一遍数组，分别找到两个单词最近出现的位置，并进行比较
    int shortestWordDistanceNaive(List<String> words, String word1, String word2) {
        if (word1.equals(word2)) return 0;
        int n = words.size(), lastAppear1 = -1, lastAppear2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String tmp = words.get(i);
            if (tmp.equals(word1)) {
                lastAppear1 = i;
                if (lastAppear2 != -1) min = Math.min(min, lastAppear1 - lastAppear2);
            }
            else if (tmp.equals(word2)) {
                lastAppear2 = i;
                if (lastAppear1 != -1) min = Math.min(min, lastAppear2 - lastAppear1);
            }
        }
        // if (min == Integer.MAX_VALUE) return Integer.MIN_VALUE; // 如果不保证一定存在word1和word2
        return min;
    }

    // 另一种解，也是过一遍数组，但是逻辑更简单，只要一个index存，如果遇到不同就更新res
    // 但是不比上一种高效，因为上一种每次至少比较1次，而这一种每次都需要比较2次
    int shortestWordDistance(List<String> words, String word1, String word2) {
        if (word1.equals(word2)) return 0;
        int n = words.size(), index = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String tmp = words.get(i);
            if (tmp.equals(word1) || tmp.equals(word2)) {
                if (index != -1 && !words.get(index).equals(tmp))
                    res = Math.min(res, i - index);
                index = i;
            }
        }
        return res;
    }
}
