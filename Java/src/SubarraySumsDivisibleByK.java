public class SubarraySumsDivisibleByK {
    // Brute-force
    public int subarraysDivByKNaive(int[] A, int K) {
        if (A == null || K < 2) return 0;
        int res = 0, n = A.length;
        if (n == 0) return 0;
        for (int start = 0; start < n; start++) {
            int currSum = 0;
            for (int end = start; end < n; end++) {
                currSum += A[end];
                if (currSum % K == 0) res++;
            }
        }
        return res;
    }

    // 需要用到前缀和数组的思想。前缀和B[i] = sum(A[0:i])
    // 在这一题，假如我们直接计算每个区间的和就会变成O(n2)。所以不能这么做
    // 考虑一下前缀和，sum(A[i:j]) = B[j] - B[i - 1]，而当sum % k == 0的时候，意味着(B[j] - B[i-1]) % K == 0
    // 那么我们有B[j] % K == B[i - 1] % K
    // 所以，我们只要计算前缀和数组中，模K余数的等价项组成的区间就可以了
    // 这里有几点需要注意的地方：
    // 1，所有模K余0的数单个都是一个区间，需要单独加一次
    // 2，对于一个大小是n的等价类，它能够组成的区间和s = (n-1)+(n-2)+...+1=n(n-1)/2
    // 3，在计算前缀和数组的时候sum只需要计算每一项对K的模就可以了；但是注意，可能得到负数，需要加K补正
    public int subarraysDivByK(int[] A, int K) {
        if (A == null || K < 2) return 0;
        int n = A.length, sum = 0;
        if (n == 0) return 0;
        int[] module = new int[K];
        for (int num : A) {
            sum = (num + sum) % K;
            if (sum < 0) sum += K;
            module[sum]++;
        }
        int res = module[0];
        for (int num:module) {
            if(num>0) res += num * (num - 1) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
