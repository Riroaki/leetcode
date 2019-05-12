import java.util.*;

// Naive version: 2ms 67%
class UniqueBST2Naive {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int from, int to) {
        List<TreeNode> res = new ArrayList<>();
        if (from > to)
            res.add(null);
        else if (from == to)
            res.add(new TreeNode(from));
        else {
            for (int i = from; i <= to; i++) {
                List<TreeNode> leftSubTrees = helper(from, i - 1);
                List<TreeNode> rightSubTrees = helper(i + 1, to);
                for (TreeNode left : leftSubTrees) {
                    for (TreeNode right : rightSubTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}
// Improved version: 1ms 100%
class UniqueBST2 {
    private Map<Integer, Map<Integer, List<TreeNode>>> results;
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        results = new HashMap<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int from, int to) {
        if (results.containsKey(from) && results.get(from).containsKey(to))
            return results.get(from).get(to);
        if (!results.containsKey(from))
            results.put(from, new HashMap<>());
        List<TreeNode> res = new ArrayList<>();
        if (from > to)
            res.add(null);
        else if (from == to)
            res.add(new TreeNode(from));
        else {
            for (int i = from; i <= to; ++i) {
                List<TreeNode> leftSubTrees = helper(from, i - 1);
                List<TreeNode> rightSubTrees = helper(i + 1, to);
                for (TreeNode left : leftSubTrees) {
                    for (TreeNode right : rightSubTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
        }
        results.get(from).put(to, res);
        return res;
    }
}
