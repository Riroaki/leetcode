import java.util.*;

public class FindNumberOfCombinationsForEquation {
    // Given an array of Integers, find out how many combinations in the array
    // that satisfy the equation x+y+z=w, where x,y,z and w belong to the array
    // and idx(x)<idx(y)<idx(z)<idx(w).
    // Elements are unique.
    public int xyzw(int[] nums) {
        if (nums == null || nums.length < 4) return 0;
        Map<Integer, List<Integer>> left = new HashMap<>();
        int res = 0;
        // 找到所有sum=x+y和y的组合
        // 注意循环的写法，这样使得list中y的顺序是从小到大排列的
        for (int y = 1; y < nums.length - 2; y++) {
            for (int x = 0; x < y; x++) {
                int sum = nums[x] + nums[y];
                if (!left.containsKey(sum)) left.put(sum, new ArrayList<>());
                left.get(sum).add(y);
            }
        }
        // 找到所有sum=w-z和z的组合
        // 由于上面list中y按顺序排列，所以可以使用binarySearch减少比较次数
        // Collections的二分查找，如果没找到就返回-(low+1)，low是上确界（等于或者大于的数的下标）
        for (int z = 2; z < nums.length - 1; z++) {
            for (int w = z + 1; w < nums.length; w++) {
                int sum = nums[w] - nums[z];
                if (left.containsKey(sum)) {
                    List<Integer> list = left.get(sum);
                    // 找到第一个可行的y的下标，此时y=z-1。如果找不到，那么-index-1就表示z-1小的数的个数
                    int index = Collections.binarySearch(list, z - 1);
                    res += index < 0 ? -index - 1 : index + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Collections.binarySearch(Arrays.asList(1, 2, 3, 4, 5, 7), 6));
        System.out.println(new FindNumberOfCombinationsForEquation().xyzw(new int[]{2, 3, 5, 1, 10}));
        System.out.println(new FindNumberOfCombinationsForEquation().xyzw(new int[]{4, 6, 9, 3, 13, 18}));
    }
}
