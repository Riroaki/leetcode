public class GasStation {
    public int canCompleteCircuitNaive(int[] gas, int[] cost) {
        int start = 0, n = gas.length;
        for (int i = 0; i < n; i++)
            gas[i] -= cost[i];
        for (; start < n; start++) {
            // Find a valid start, whose gas > cost.
            if (gas[start] >= 0) {
                int current = gas[start];
                boolean canTravel = true;
                for (int i = 1; i < n; i++) {
                    current += gas[(start + i) % n];
                    if (current < 0) {
                        canTravel = false;
                        break;
                    }
                }
                if (canTravel)
                    return start;
            }
        }
        return -1;
    }

    //首先，将每个站的消耗和油量相加，可以得到一个序列A，问题可以等价于：
    //寻找一个起始点i，使得按照i开始形如A[i], A[i+1], A[i+2], ..., A[n-1], A[0], ..., A[i-1]的排列满足，从这个排列的第一个元素到后续任意长的子序列的和都非负。

    //这个思路的证明：
        //1，如果总消耗小于总油量，那么一定存在上面要求的i。
            //这一点个人证明不了，求证？？
        //2，如果从i出发，到j站时出现负数的和，那么从i-j之间的站出发，一定也会出现负数的和，不满足要求。
            //反证法证明：假如i到j之间有一点k，而k到j项的和非负，那么因为i到k项的和已经非负，那么i到j项的和肯定也非负，和假设相反。
        //3，由于题目说明，如果有解则保证解唯一，那么通过第1点排除了没有解的情况，得到的i不一定就满足条件，但是一定是当前的最优解，如此一来i只能是所求的解。
            //（[0, i-1]一定不满足，理由见2；而[i+1, n-1]，肯定不如i，理由同2的证明）
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, start = 0, totalSum = 0, currentSum = 0;
        if (n == 0) return -1;
        for (int i = 0; i < n; i++) {
            gas[i] -= cost[i];
            totalSum += gas[i];
            currentSum += gas[i];
            if (currentSum < 0) {
                currentSum = 0;
                start = i + 1;
            }
        }
        return totalSum < 0 ? -1 : start % n;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
        System.out.println(new GasStation().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        System.out.println(new GasStation().canCompleteCircuit(new int[]{}, new int[]{}));
    }
}
