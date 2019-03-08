import java.util.*;

public class LongestConsecutive {
    // 这不是O（n）的做法，因为使用了sort；但是效率足够快了
    public int longestConsecutiveNaive(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        Arrays.sort(nums);
        int res = 0;
        for (int index = 0; index < n - 1; index++) {
            int currentLen = 1;
            while (index < n - 1) {
                // 遇到重复元素的时候长度不增加
                if (nums[index + 1] == nums[index] + 1) currentLen++;
                else if (nums[index + 1] > nums[index] + 1) break;
                index++;
            }
            res = Math.max(res, currentLen);
        }
        return res;
    }


    // 自己想的O(n)做法，用一个map<int, int[2]>记录一个数和它的两端
    public int longestConsecutiveMap(int[] nums) {
        int n = nums.length, res = 1;
        if (n < 2) return n;
        Map<Integer, int[]> numMap = new HashMap<>();
        for (int num : nums) {
            // 如果已经插入过就不需要再更新
            if (numMap.containsKey(num))
                continue;
            boolean hasLeft = numMap.containsKey(num - 1),
                hasRight = numMap.containsKey(num + 1);
            int currentLen = 1;
            if (hasLeft && hasRight) {// 如果左右都可以延伸，则连接了两端
                int left = numMap.get(num - 1)[0],
                    right = numMap.get(num + 1)[1];
                currentLen = 3 + left + right;
                numMap.put(num, new int[]{left + 1, right + 1});// 其实这里num的左右两侧无关紧要，只要插入一个数就行
                numMap.get(num - 1 - left)[1] += right + 2;
                numMap.get(num + 1 + right)[0] += left + 2;
            } else if (hasLeft) {// 如果只有左侧可以延伸
                int left = numMap.get(num - 1)[0];// 左测在num-1左边还有left个数
                currentLen = 2 + left;
                numMap.put(num, new int[]{left + 1, 0});
                numMap.get(num - 1 - left)[1]++;// 最左侧记录右侧数目++
            } else if (hasRight) { // 如果只有右侧可以延伸
                int right = numMap.get(num + 1)[1];// 右侧在num+1右边还有right个数
                currentLen = 2 + right;
                numMap.put(num, new int[]{0, right + 1});
                numMap.get(num + 1 + right)[0]++;// 最右侧记录左侧数目++
            } else // 这个表示左右两端有0个数
                numMap.put(num, new int[]{0, 0});
            res = Math.max(res, currentLen);
        }
        return res;
    }

    // 这里用set，更加巧妙，比map操作少多了
    // 遍历一遍把所有元素加入set，然后遍历找每个数左边有没有数（找到左端点，然后往右找得到这一节的长度）
    // 时间复杂度也是O(n)，看起来有两层循环，但是仔细想想里面那个while只有在是左端点的时候才会执行，那么不可能出现重复查询
    // 这样一来所有的遍历也不过是查询了一遍整个数组，每次查询效率是O(1)，所以总效率是O(n)
    public int longestConsecutiveSet(int[] nums) {
        int res = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);
        for (int num : nums) {
            if (numSet.contains(num - 1))
                continue;
            int currentLen = 1;
            while (numSet.contains(num + currentLen))
                currentLen++;
            res = Math.max(currentLen, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new LongestConsecutive().longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
