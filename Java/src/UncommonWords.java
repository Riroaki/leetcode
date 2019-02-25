import java.util.*;

public class UncommonWords {
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" "), b = B.split(" ");
        HashMap<String, Integer> res = new HashMap<>();
        for (String s : a) {
            if (res.containsKey(s)) res.put(s, res.get(s) + 1);
            else res.put(s, 1);
        }
        for (String s : b) {
            if (res.containsKey(s)) res.put(s, res.get(s) + 1);
            else res.put(s, 1);
        }
        List<String> c = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            if (entry.getValue() == 1) c.add(entry.getKey());
        }
        return c.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new UncommonWords().uncommonFromSentences("fd kss fd", "fd fd kss")));
    }
}
