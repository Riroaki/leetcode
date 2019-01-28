public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0, current;
        while (left < right) {
            if (height[left] < height[right]) {
                current = (right - left) * height[left];
                left++;
            } else {
                current = (right - left) * height[right];
                right--;
            }
            max = max > current ? max : current;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
