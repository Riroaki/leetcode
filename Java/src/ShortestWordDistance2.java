import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance2 {
    private HashMap<String, List<Integer>> wordMap = new HashMap<>();

    void wordDistance(List<String> words) {
        if (wordMap.isEmpty()) {
            for (int index = 0; index < words.size(); index++) {
                String tmp = words.get(index);
                if (!wordMap.containsKey(tmp)) wordMap.put(tmp, new ArrayList<>());
                wordMap.get(tmp).add(index);
            }
        }
    }

    int shortest(String word1, String word2) {
//        if (word1.equals(word2)) return 0;
        List<Integer> indexList1 = wordMap.get(word1);
        List<Integer> indexList2 = wordMap.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < indexList1.size() && j < indexList2.size(); ) {
            int tmp1 = indexList1.get(i), tmp2 = indexList2.get(j);
            if (tmp1 > tmp2) {
                res = Math.min(res, tmp1 - tmp2);
                j++;
            } else {
                res = Math.min(res, tmp2 - tmp1);
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("coding");
        wordList.add("makes");
        wordList.add("perfect");
        String a = "coding", b = "perfect";
        ShortestWordDistance2 test = new ShortestWordDistance2();
        test.wordDistance(wordList);
        System.out.println(test.shortest(a, b));
    }
}
