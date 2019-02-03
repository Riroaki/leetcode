import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class VerticalOrderTraversal {
    private List<List<Integer>> nodes = new ArrayList<>();

    private void traversal(TreeNode root, int x, int y) {
        if (root == null) return;
        nodes.add(new ArrayList<>(Arrays.asList(x, y, root.val)));
        traversal(root.left, x - 1, y - 1);
        traversal(root.right, x + 1, y - 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        traversal(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        Comparator<List<Integer>> comparator = (l1, l2) -> {
            if (l1.get(0) > l2.get(0)) return 1;
            else if (l1.get(0) < l2.get(0)) return -1;
            else if (l1.get(1) < l2.get(1)) return 1;
            else if (l1.get(1) > l2.get(1)) return -1;
            else if (l1.get(2) > l2.get(2)) return 1;
            else if (l1.get(2) < l2.get(2)) return -1;
            else return 0;
        };
        nodes.sort(comparator);
        int curr, index = 0;
        while (index < nodes.size()) {
            curr = nodes.get(index).get(0);
            List<Integer> currLevel = new ArrayList<>();
            while (index < nodes.size() && nodes.get(index).get(0) == curr)
                currLevel.add(nodes.get(index++).get(2));
            res.add(currLevel);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new VerticalOrderTraversal().verticalTraversal(root));
    }
    // [0,1,4,2,8,37,13,3,34,14,29,66,45,22,19,5,6,39,69,null,17,null,35,null,null,null,null,32,null,null,58,null,9,10,7,null,55,89,null,42,51,57,null,86,null,null,null,11,18,53,15,12,null,null,null,null,null,48,null,80,84,75,65,null,null,26,64,27,21,61,null,null,16,33,23,52,63,null,null,null,null,null,null,null,null,null,71,null,null,28,54,24,38,76,null,25,20,60,null,47,null,null,null,null,79,null,81,36,null,74,88,null,31,null,null,null,null,null,49,null,30,null,null,null,null,null,null,null,null,null,43,null,null,null,null,59,40,null,50,41,44,56,null,62,null,46,67,68,78,73,null,83,null,77,null,null,null,null,72,70,null,85,null,null,null,82,87]
    // [1, 2, 3, 4, 5, 6, 7]
    // [0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9]
}
