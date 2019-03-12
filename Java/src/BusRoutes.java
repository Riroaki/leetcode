public class BusRoutes {
    // Naive version. 
    private int[][] dist;
    private boolean[] visited;

    // 这个算法似曾相识。。虽然卡了我一下，但是关键点需要记住
    private int findDist(int s, int e) {
        // s == e or s could reach e.
        if (dist[s][e] < Integer.MAX_VALUE)
            return dist[s][e];
        int res = Integer.MAX_VALUE;
        visited[s] = true;// 这个很关键，避免循环
        for (int mid = 0; mid < dist[s].length; mid++) {
            if (mid == s || dist[s][mid] >= res || visited[mid]) // 这里避免s==mid，也很关键
                continue;
            int tmp = findDist(mid, e);
            if (tmp < Integer.MAX_VALUE)
                res = Math.min(res, tmp + dist[s][mid]); // s->e == s->mid + mid->e
        }
        visited[s] = false;
        return dist[s][e] = res;
    }

    // 将公交车视作节点，将所有可以到达s的车视为起点，所有可以到达t的车视为终点
    // 题目就是求从所有的起点车出发，到达所有的终点车的距离最小值
    // 那么首先，求出所有可以到达s的车节点和到达t的车节点
    // 然后存下从某一辆车到另一辆车的距离（这里用了邻接矩阵存，所有到达不了就是Integer最大值）
    // 存下所有有共同车站的车，他们之间两两距离为1
    // 最后用dfs遍历所有可能，注意+1，到达不了返回-1
    public int numBusesToDestination(int[][] routes, int s, int t) {
        // 特殊情况，不用上车
        if (s == t)
            return 0;
        int n = routes.length;
        dist = new int[n][n];
        visited = new boolean[n];
        List<Integer> start = new ArrayList<>(), end = new ArrayList<>();
        // 设置到达不了为MAX_VALUE，到自己为距离0
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        // 使用binarySearch判断是否存在s或者t，效率较高
        for (int i = 0; i < n; i++) {
            Arrays.sort(routes[i]);
            if (Arrays.binarySearch(routes[i], s) >= 0)
                start.add(i);
            if (Arrays.binarySearch(routes[i], t) >= 0)
                end.add(i);
        }
        // 将所有有共同车站的车距离设为1
        // 同样利用了上面排序好的特性
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int i1 = 0, i2 = 0;
                while (i1 < routes[i].length && i2 < routes[j].length) {
                    if (routes[i][i1] == routes[j][i2]) {
                        dist[i][j] = 1;
                        break;
                    }
                    if (routes[i][i1] < routes[j][i2])
                        i1++;
                    else
                        i2++;
                }
            }
        }
        // 计算每个起点到终点的距离最小值，记忆化+回溯
        int res = Integer.MAX_VALUE;
        for (int st : start)
            for (int en : end)
                res = Math.min(res, findDist(st, en));
        return res == Integer.MAX_VALUE ? -1 : res + 1; // 答案不要忘记+1，就是上第一个车需要
    }
}

