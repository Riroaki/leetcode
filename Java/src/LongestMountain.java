public class LongestMountain {
    public int longestMountain(int[] A) {
        int res = 0, index = 0, start = 0, top = 0, n = A.length;
        // 因为最短也有3，所以是n-2
        while (index < n - 2) {
            // 如果出现递增，就开始找山
            if (A[index + 1] > A[index]) {
                start = index;
                // 找到山顶，保存为top
                while (index < n - 1 && A[index + 1] > A[index])
                    index++;
                top = index;
                // 从top向下找山脚
                while (index < n - 1 && A[index + 1] < A[index])
                    index++;
                // 不成山
                if (index == top)
                    continue;
                // 注意。山和山之间可能公用一个山脚，所以这里index停在山脚的位置不能往前
                // System.out.println(start+" "+top+" "+index);
                res = Math.max(index - start + 1, res);
            } else // 没找到就前进
                index++;
        }
        return res;
    }
}
