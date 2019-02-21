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

    // Method 2: O(n2) time, O(1) space
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

    // Method 3: O(n log n) time, O(1) space
    static private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void merge(int[] arr, int from, int to) {
        int n = to - from;
        if (n < 4) return;
        if (n == 4) swap(arr, from + 1, to - 2);
        else {
            int start1 = n / 4 + from, start2 = n / 2;
            while (start1 < n / 2) swap(arr, start1++, start2++);
            merge(arr, from, start1);
            merge(arr, start1, to);
        }
    }

    public void rearrangeMerge(int[] arr) {
        if (arr == null || arr.length < 2) return;
        merge(arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 2, 4, 6, 8};
        new RearrangeArray().rearrangeMerge(a);
        System.out.println(Arrays.toString(a));

        int[] b = {1, 3, 5, 2, 4, 6};
        new RearrangeArray().rearrangeMerge(b);
        System.out.println(Arrays.toString(b));
    }
}
