public class FlowerPlantingWithNoAdjacent {
    // for each position, test all adjacent positions' colors and choose color with minimum index
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; ++i)
            graph.put(i, new ArrayList<>());
        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        res[0] = 1;
        for (int i = 2; i <= n; ++i) {
            // start counting from minimum color index
            int color = 1;
            while (color < 5) {
                boolean find = true;
                for (int j : graph.get(i)) {
                    if (res[j - 1] == color) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    res[i - 1] = color;
                    break;
                } else
                    color++;
            }
            // if no color is found, the case is invalid
            if (color == 5)
                System.out.println("Invalid case!");
        }
        return res;
    }
}
