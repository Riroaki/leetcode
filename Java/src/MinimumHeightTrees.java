public class MinimumHeightTrees {
    // ...emmm这题有点拓扑的味道
    // 从一堆leave开始迭代，把旧的叶节点从树上摘除，剩下来新的叶节点组成新的list继续迭代；
    // 直到数量小于2个。。但是我不理解为什么一定只有两个解？？？这个解法我也是仏了
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new HashSet<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (graph.get(i).size() == 1)
                leaves.add(i);
        while (n > 2) {
            n -= leaves.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i : leaves) {
                int t = graph.get(i).iterator().next();
                graph.get(t).remove(i);
                if (graph.get(t).size() == 1)
                    tmp.add(t);
            }
            leaves = tmp;
        }
        return leaves;
    }

    // Naive version. bfs, but TLE.
    public List<Integer> findMinHeightTreesNaive(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new HashSet<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int globalMin = n;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> nodes = new LinkedList<>();
            Queue<Integer> depth = new LinkedList<>();
            nodes.offer(i);
            depth.offer(0);
            int maxDepth = 0;
            while (!nodes.isEmpty()) {
                int curr = nodes.poll(), dep = depth.poll();
                visited.add(curr);
                maxDepth = Math.max(maxDepth, dep);
                dep++;
                for (int node : graph.get(curr)) {
                    if (visited.contains(node))
                        continue;
                    nodes.offer(node);
                    depth.offer(depth);
                }
            }
            if (maxDepth < globalMin) {
                res.clear();
                res.add(i);
                globalMin = maxDepth;
            } else if (maxDepth == globalMin)
                res.add(i);
        }
        return res;
    }
}
