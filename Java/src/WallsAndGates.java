public class WallsAndGates {
    private int h, w;
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        h = rooms.length;
        if (h == 0)
            return;
        w = rooms[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (rooms[i][j] == 0)
                    dfs(rooms, i, j, 0);
            }
        }
    }

    // Update the distances; when current distance is smaller, stop traveling this way.
    // smaller includes -1 and real smallers.
    // Also, when traveling back, the distance will be larger so prevents traveling back.
    private void dfs(int[][] rooms, int i, int j, int curr) {
        if (i < 0 || i >= h || j < 0 || j >= w || rooms[i][j] < curr)
            return;
        rooms[i][j] = curr;
        curr++;
        for (int i = 0; i < 4; i++)
            dfs(rooms, i + dirs[i][0], j + dirs[i][1], curr);
    }
}
