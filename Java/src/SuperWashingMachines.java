public class SuperWashingMachines {
	// 这里是参考网上的解法。这一题应用在负载均衡方面
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0)
            return -1;
        int sum = 0, n = machines.length;
        for(int num : machines)
            sum += num;
	// 如果无法平均分配
        if (sum % n != 0)
            return -1;
        int avg = sum / n, res = 0;
	// left表示i左边（不包括i）一共需要转移多少衣服
	// right表示i右边……
        int[] left = new int[n], right = new int[n];
        for (int i = 1; i < n ; i++)
            left[i] = left[i - 1] + machines[i - 1] - avg;
        for (int i = n - 2; i >= 0; i--)
            right[i] = right[i + 1] + machines[i + 1] - avg;
        // 这里的逻辑很重要。
	// 如果left和right都是负数，那么说明这个位置需要向两侧输出衣服。
		// 但是输出不能同时进行，所以取左右的相反数之和
	// 如果left和right都是正数，那么说明这个位置需要两侧输入衣服。
		// 因为左右两侧同时进行，所以取左右两侧max
	// 否则同左右两侧的绝对值比较，取max
	for (int i = 0; i < n; i++) {
            if (left[i] < 0 && right[i] < 0)
                res = Math.max(res, -left[i] - right[i]);
            else if(left[i] > 0 && right[i] > 0)
                res = Math.max(res, Math.max(left[i], right[i]));
            else
                res = Math.max(res, Math.max(Math.abs(left[i]), Math.abs(right[i])));
        }
        return res;
    }
}
