import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition {
    // 这道题讲起来复杂，但是实际上问的是图。
    // 把每个人作为一个节点，两个讨厌的人连接起来，构成一张图。
    // 我讨厌的人讨厌的人和我是一个阵营，也就是说"我敌人的敌人是我的朋友"
    // 那么这里如果存在奇数节点的环，就会出现不能分割的情况。偶数节点则可以，没有成环那更好了
    private List<List<Integer>> graph;
    boolean[] visited;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList<>(N);
        visited = new boolean[N];
        // 建立邻接表
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        for (int[] pair : dislikes) graph.get(pair[0]).add(pair[1]);
        for (int from = 0; from < N; from++) {
            int circleSize = 0;
        }
        return true;
    }
}
