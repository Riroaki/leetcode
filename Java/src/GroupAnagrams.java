public class GroupAnagrams {
    // 一次过，简单无敌：将每个词里面字母排序后重组的string和原词组成map
    // 从map的values中提取答案即可
    // 其他方法也差不多，总之是用map，重点在于生成唯一的标识符（也可以用26字母出现次数，用#分割后组成字符串）
    // 后者时间复杂度更低，因为只需要过一遍数组就可以了；这里排序所以效率会低一点
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String sorted = String.valueOf(tmp);
            if (!res.containsKey(sorted))
                res.put(sorted, new ArrayList<>());
            res.get(sorted).add(s);
        }
        return new ArrayList<List<String>>(res.values());
    }
}
