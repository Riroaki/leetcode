public class RomanToInteger {
    // 罗马数制的规则很简单：如果某个位代表的数前面的位代表的数比这个位小，那么就代表减；否则为加
        // 也就是说，如果都是递减，那么只把所有的位相加就可以了；不然，就要减这个数
    public int romanToInt(String s) {
        Map<Character, Integer> numMap = new HashMap<>();
        numMap.put('I', 1);
        numMap.put('V', 5);
        numMap.put('X', 10);
        numMap.put('L', 50);
        numMap.put('C', 100);
        numMap.put('D', 500);
        numMap.put('M', 1000);
        int[] nums = new int[s.length()];
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++)
            nums[i] = numMap.get(s.charAt(i));
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1])
                res -= nums[i];
            else
                res += nums[i];
        }
        return res + nums[n - 1];
    }
}
