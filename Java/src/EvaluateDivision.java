public class EvaluateDivision {
    // 1.0 method, 2ms 50%, graph + queue-based bfs.
    // time complexity: O(e) + O(m * (n + e)), n是节点数（不是代码中的n），e是边数，m是query数
    // bfs和dfs在时间和空间复杂度上一样，但是访问顺序不同；
    // 如果采用邻接矩阵存储，那么遍历的效率为O(n2)，否则遍历效率为O(n + e)，n为节点数，e为边数
    public double[] calcEquationNaive(String[][] equations, double[] values, String[][] queries) {
        int n = equations.length, m = queries.length;
        double[] res = new double[m];
        Map<String, Map<String, Double>> rates = new HashMap<>();
        // 将方程转换为图，将两个string变成node，value是其中的边。
        // 注意对称性
        for (int i = 0; i < n; i++) {
            String from = equations[i][0], to = equations[i][1];
            rates.putIfAbsent(from, new HashMap<>());
            rates.putIfAbsent(to, new HashMap<>());
            rates.get(from).put(to, values[i]);
            rates.get(to).put(from, 1.0 / values[i]);
        }
        for (int i = 0; i < m; i++) {
            String from = queries[i][0], to = queries[i][1];
            if (!rates.containsKey(from) || !rates.containsKey(to))
                res[i] = -1.0;
            else if (from.equals(to))
                res[i] = 1.0;
            else {
                Queue<String> q1 = new LinkedList<>();
                Queue<Double> q2 = new LinkedList<>();
                Set<String> visited = new HashSet<>();
                boolean found = false;
                q1.offer(from);
                q2.offer(1.0);
                while (!q1.isEmpty()) {
                    String curr = q1.poll();
                    double val = q2.poll();
                    if (curr.equals(to)) {
                        found = true;
                        res[i] = val;
                        break;
                    } else {
                        for (Map.Entry<String, Double> entry : rates.get(curr).entrySet()) {
                            if (visited.contains(entry.getKey()))
                                continue;
                            q1.offer(entry.getKey());
                            q2.offer(val * entry.getValue());
                        }
                    }
                    visited.add(curr);
                }
            }
        }
        return res;
    }
    // union find

}
