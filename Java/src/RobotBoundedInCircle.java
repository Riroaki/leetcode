public class RobotBoundedInCircle {
    // Go under instructions for 4 times and see whether it returns to (0, 0).
    public boolean isRobotBounded(String s) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curr = 0, n = s.length();
        int[] pos = new int[]{0, 0};
        // go for 4 rounds and check
        for (int j = 0; j < 4; ++j) {
            for (int i = 0; i < n; ++i) {
                if (s.charAt(i) == 'G') {
                    pos[0] += dirs[curr][0];
                    pos[1] += dirs[curr][1];
                } else if (s.charAt(i) == 'L')
                    curr = (curr + 3) % 4;
                else
                    curr = (curr + 1) % 4;
            }
        }
        return pos[0] == 0 && pos[1] == 0;
    }
}
