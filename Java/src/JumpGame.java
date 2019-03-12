class JumpGameRecursive {
    public boolean canJump(int[] nums) {
        int dest = 0;
        for (int i = 0; i < nums.length; i++)
            if (i <= dest)
                dest = Math.max(dest, nums[i] + i);
        return dest >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameRecursive().canJump(new int[]{0}));
        System.out.println(new JumpGameRecursive().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGameRecursive().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
