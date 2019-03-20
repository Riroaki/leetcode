interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}

public class RobotRoomCleaner {
    private int[][] dirs = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private Set<String> cleaned;

    public void cleanRoom(Robot robot) {
        cleaned = new HashSet<>();
        helper(robot, 0, 0, 0);
    }

    private void helper(Robot robot, int dir, int x, int y) {
        robot.clean();
        visited.add(x + "#" + y);
        for (int i = 0; i < 4; i++, dir = (dir + i) % 4) {
            int nextX = x + dirs[dir][0], nextY = y + dirs[dir][1];
            if (!visited.contains(nextX + "#" + nextY) && robot.move()) {
                helper(robot, dir, nextX, nextY);
                // 重要！回溯到原来位置并恢复原来方向！
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}
