import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ShortestPathInMaze {
    public int shortestPath(char[][] maze) {
        int height = maze.length, width = maze[0].length;
        int[][] dist = new int[height][width],
                dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[] start = new int[]{0, 0}, end = new int[]{0, 0};
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if (maze[i][j] == 's')
                    start = new int[]{i, j};
                else if (maze[i][j] == 'e')
                    end = new int[]{i, j};
        for (int i = 0; i < height; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;
        q.push(start);

        int[] next = new int[]{0, 0};
        while (q.isEmpty()) {
            int[] curr = q.pop();
            for (int i = 0; i < 4; i++) {
                next[0] = curr[0] + dir[i][0];
                next[1] = curr[1] + dir[i][1];
                if (next[0] >= 0 && next[0] < height
                        && next[1] >= 0 && next[1] < width
                        && maze[next[0]][next[1]] != '#'
                        && dist[next[0]][next[1]] == Integer.MAX_VALUE) {
                    dist[next[0]][next[1]] = dist[curr[0]][curr[1]] + 1;
                    if (end[0] == next[0] && end[1] == next[1])
                        break;
                }
            }
            if (dist[end[0]][end[1]] != Integer.MAX_VALUE)
                break;
        }
        return dist[end[0]][end[1]] == Integer.MAX_VALUE ? -1 : dist[end[0]][end[1]];
    }

    public static void main(String[] args) {
        char[][] maze = new char[][]{
                {}
        };
    }
}
