public class WordLadder2 {
    // Naive version, got TLE.
    /*
    private Map<String, List<String>> next;
    private Map<String, Boolean> visited;
    private String to;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> words) {
        visited = new HashMap<>();
        for (String tmp : words)
            visited.put(tmp, false);
        if (!visited.containsKey(endWord))
            return new LinkedList<>();
        // Append in copy, in case the original list is unmodifiable
        List<String> wordList = new LinkedList<>(words);
        if (!visited.containsKey(beginWord))
            wordList.add(beginWord);
        int n = wordList.size();
        // find next words for all words in list.
        next = new HashMap<>();
        for (String s : wordList)
            next.put(s, new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            String a = wordList.get(i);
            for (int j = i + 1; j < n; ++j) {
                String b = wordList.get(j);
                int diff = 0;
                for (int k = 0; k < a.length(); k++) {
                    if (a.charAt(k) != b.charAt(k)) {
                        diff++;
                        if (diff > 1)
                            break;
                    }
                }
                if (diff == 1) {
                    next.get(a).add(b);
                    next.get(b).add(a);
                }
            }
        }
        // dfs and find all shortest paths
        to = endWord;
        return dfs(beginWord);
    }

    private List<List<String>> dfs(String from) {
        List<List<String>> res = new LinkedList<>();
        if (from.equals(to)) {
            List<String> tmp = new LinkedList<>();
            tmp.add(from);
            res.add(tmp);
        } else {
            visited.put(from, true);
            for (String curr : next.get(from)) {
                if (!visited.get(curr)) {
                    List<List<String>> paths = dfs(curr);
                    for (List<String> path : paths) {
                        List<String> copy = new LinkedList<>(path);
                        copy.add(0, from);
                        res.add(copy);
                    }
                }
            }
            visited.put(from, false);
        }
        int min = Integer.MAX_VALUE;
        for (List<String> path : res)
            min = Math.min(path.size(), min);
        List<List<String>> minPaths = new LinkedList<>();
        for (List<String> path : res)
            if (path.size() == min)
                minPaths.add(path);
        return minPaths;
    }
    */

}
