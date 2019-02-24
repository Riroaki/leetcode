public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = nums1.length / 2 + nums2.length / 2, num1 = -1, num2 = -1;
        for (int i = 0, j = 0; i < nums1.length && j < nums1.length; ) {

        }
        if (nums1.length % 2 + nums2.length % 2 == 1) return num1;
        return num2;
    }
}
