public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length, odd = 1, even = 0;
        int[] res = new int[n];
        for (int num : A) {
            if (num % 2 == 1) {
                res[odd] = num;
                odd += 2;
            } else {
                res[even] = num;
                even += 2;
            }
        }
        return res;
    }
}
