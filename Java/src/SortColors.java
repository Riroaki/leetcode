public class SortColors {
    // sort by counting, two pass.
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums)
            count[num]++;
        for (int i = 0, index = 0; i < 3; i++)
            for (int j = 0; j < count[i]; j++)
                nums[index++] = i;
    }

    // by swap. one pass.
    // keep 0 at [0, zero), 2 at (second, n - 1], and then 1 will automatically be at middle.
    public void sortColors(int[] nums) {
        int second=n-1, zero=0;
        for (int i=0; i<=second; i++) {
            while (A[i]==2 && i<second) swap(A[i], A[second--]);
            while (A[i]==0 && i>zero) swap(A[i], A[zero++]);
        }
    }

    // by ... brilliant idea.
    public void sortColors(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        for (int k = 0; k < n; k++) {
            int curr = nums[k];
            nums[k] = 2;
            if (curr < 2)
                nums[j++] = 1;
            if (curr == 0)
                nums[i++] = 0;
        }
    }
}
