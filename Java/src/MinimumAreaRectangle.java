import java.util.*;

public class MinimumAreaRectangle {
    // 简单想法，88%。这里使用一个Map存所有相等x坐标的y坐标值
    // 然后对所有相同x坐标list进行排序，然后对map里面的数，通过比较找到相等的列表
    // 对相等列表里面取diffY的最小值，也就是两两比较取最小值。
    // 相当于把所有可能组成矩形的组合都过了一遍。。。200+ms
    // 整体时间复杂度n2lg n左右。空间复杂度也很高。
    public int minAreaRectNaive(int[][] points) {
        int res = Integer.MAX_VALUE;
        // map of equal x-value points, store the y-value.
        HashMap<Integer, List<Integer>> pointMap = new HashMap<>();
        for (int[] p : points) {
            if (!pointMap.containsKey(p[0]))
                pointMap.put(p[0], new ArrayList<>());
            pointMap.get(p[0]).add(p[1]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : pointMap.entrySet())
            Collections.sort(entry.getValue());
        for (Map.Entry<Integer, List<Integer>> entry1 : pointMap.entrySet()) {
            int x1 = entry1.getKey();
            for (Map.Entry<Integer, List<Integer>> entry2 : pointMap.entrySet()) {
                int x2 = entry2.getKey();
                if (x1 <= x2)
                    continue;
                List<Integer> commonY = new ArrayList<>(),
                        l1 = entry1.getValue(), l2 = entry2.getValue();
                int i = 0, j = 0;
                while (i < l1.size() && j < l2.size()) {
                    if (l1.get(i).equals(l2.get(j))) {
                        commonY.add(l1.get(i));
                        i++;
                        j++;
                    } else if (l1.get(i).compareTo(l2.get(j)) > 0)
                        j++;
                    else i++;
                }
                // 没有相同y坐标的2个点
                if (commonY.size() < 2)
                    continue;
                int minDiffY = Integer.MAX_VALUE;
                for (int k = 1; k < commonY.size(); k++)
                    minDiffY = Math.min(minDiffY, commonY.get(k) - commonY.get(k - 1));
                res = Math.min((x1 - x2) * minDiffY, res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 这个做法简洁明了。同样遍历了所有组成矩形的可能，但是做的工作少很多。简洁就是力量
    // 但是空间复杂度是n2，所以只是一个初步想法
    // 390ms。。。啥情况
    public int minAreaRectMap(int[][] points) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer, HashSet<Integer>> pointMap = new HashMap<>();
        // 存下了所有相同x排列的，y无序的集合
        for (int[] p : points) {
            if (!pointMap.containsKey(p[0]))
                pointMap.put(p[0], new HashSet<>());
            pointMap.get(p[0]).add(p[1]);
        }
        // 对集合中任意两个x、y各不相同的点，让他们组成对角线
        // 再在原来的map里面找到能组成矩形的另外两个点。
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1])
                    continue;
                if (pointMap.get(p1[0]).contains(p2[1]) && pointMap.get(p2[0]).contains(p1[1]))
                    res = Math.min(res, Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1])));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // 以下两种方法，作用和第二种类似，但是关键在于压缩了信息使得x，y变成一个独特信息可以直接找到。
    // 不然对x，y的二维组合找值，效率低而且空间复杂度高。
    // 压缩可以转化为string或者相乘（要保证一一对应，取max+1作为一个进制）

    // 这个方法只用一个hash set来记录每个节点就可以了，空间复杂度较低
    // 秘诀在于将每个坐标点转化成String（也可以根据范围，存两个数相乘的结果，不过可能溢出就是了）
    // 这个方法虽然理论上简单，但是由于String组合，所以效率反而最低。
    public int minAreaRectString(int[][] points) {
        HashSet<String> pointSet = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int[] p : points) {
            String a = p[0] + " " + p[1];
            pointSet.add(a);
        }
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1])
                    continue;
                String a = p1[0] + " " + p2[1], b = p2[0] + " " + p1[1];
                if (pointSet.contains(a) && pointSet.contains(b))
                    res = Math.min(res, Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1])));
            }
        }
        return res;
    }

    // 这是最快的，只需要一点乘法就可以了。155ms击败95%
    public int minAreaRect(int[][] points) {
        HashSet<Integer> pointSet = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int[] p : points)
            pointSet.add(p[0] * 40001 + p[1]);
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1])
                    continue;
                int a = p1[0] * 40001 + p2[1], b = p1[1] + p2[0] * 40001;
                if (pointSet.contains(a) && pointSet.contains(b))
                    res = Math.min(res, Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1])));
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    public static void main(String[] args) {
        System.out.println(new MinimumAreaRectangle().minAreaRect(new int[][]
                {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}));
    }
}
