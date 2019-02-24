public class LongestCommonPrefix {
    // 这个按理说效率应该差不多，但是实际效率低
    public String longestCommonPrefixNaive(String[] strs) {
        if (strs.length == 0) return "";
        int res = 0;
        while (res < strs[0].length()) {
            char tmp = strs[0].charAt(res);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() - 1 < res || strs[i].charAt(res) != tmp)
                    return strs[0].substring(0, res);
                System.out.println(strs[i].charAt(res));
            }
            res++;
        }
        return strs[0].substring(0, res);
    }

    // 这是先两两比较，截出短的再往下和其他比
    // 另外是不要忘记数组可以指向null，因为Java的数组是引用
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (!strs[i].startsWith(pre))
                pre = pre.substring(0, pre.length() - 1);
            if (pre.length() == 0) break;
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "floor", "flight"}));
    }
}
