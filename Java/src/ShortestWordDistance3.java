import java.util.List;

public class ShortestWordDistance3 {
    // 允许出现相同的字符串比较，而且其值为两个相同的字符串相邻位置的最小距离
    int shortestWordDistance(List<String> words, String word1, String word2) {
        int n = words.size(), lastAppear1 = -1, lastAppear2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String tmp = words.get(i);
            if (tmp.equals(word1)) {
                lastAppear1 = i;
                if (lastAppear2 != -1) min = Math.min(min, lastAppear1 - lastAppear2);
            }
            // 允许相同字符串的比较
            if (tmp.equals(word2)) {
                lastAppear2 = i;
                // 只在两个位置不同的时候进行比较
                if (lastAppear1 != -1 && lastAppear1 != lastAppear2) min = Math.min(min, lastAppear2 - lastAppear1);
            }
        }
        return min;
    }
}
