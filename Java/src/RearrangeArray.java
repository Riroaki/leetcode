import java.util.Arrays;

public class RearrangeArray {
    // Rearrange {a0, a1, a2, a3, ..., an, b0, b1, b2, ..., bn}
    // to {a0, b0, a1, b1, ..., an, bn}

    // Method 1: O(n) time, but O(n) space
    static public void rearrangeNaive(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length, i = 0, j = n / 2, curr = 0;
        int[] tmp = new int[n];
        while (curr < n) {
            tmp[curr++] = arr[i++];
            tmp[curr++] = arr[j++];
        }
        System.arraycopy(tmp, 0, arr, 0, n);
    }

    static public void rearrangeNaive2(int[] arr) {
        if (arr == null || arr.length < 4) return;
        int n = arr.length / 2;
        // 每次把新的bi换到2*i+1的位置，然后从2*i+1开始到bi往后移位
        for (int i = 0; i < n; i++) {
            int tmp = arr[n + i];
            for (int j = n + i; j > 2 * i + 1; j--) arr[j] = arr[j - 1];
            arr[2 * i + 1] = tmp;
        }
    }

    // Method 2: O(n2) time, O(1) space
    // 比较巧妙，不容易想到。。。我服了这个，其实n2的算法也可以用更简单的思路
    static public void rearrange(int[] arr) {
        int swaps = arr.length / 2 - 1;
        for (int j = arr.length / 2; j < arr.length; j++) {
            int i = j;
            while (swaps > 0) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
                swaps--;
            }
            swaps = arr.length - j - 2;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 2, 4, 6, 8};
        rearrangeNaive2(a);
        System.out.println(Arrays.toString(a));

        int[] b = {1, 3, 5, 2, 4, 6};
        rearrangeNaive2(b);
        System.out.println(Arrays.toString(b));
    }
}
