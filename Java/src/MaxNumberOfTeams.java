import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaxNumberOfTeams {
    public int maxNumberOfTeams(int[] countries, int k) {
        if (countries == null || countries.length == 0 || k <= 0) return 0;
        PriorityQueue<Integer> candidatePool = new PriorityQueue<>(Collections.reverseOrder());// (o1, o2) -> o2 - o1)
        for (int country : countries) {
            if (country <= 0) return -1;
            candidatePool.offer(country);
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while (candidatePool.size() >= k) {
            for (int i = 0; i < k; i++) {
                int country = candidatePool.poll();
                if (--country > 0) stack.push(country);
            }
            while (!stack.empty()) candidatePool.offer(stack.pop());
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxNumberOfTeams().maxNumberOfTeams(new int[]{1, 3, 5}, 3));
        System.out.println(new MaxNumberOfTeams().maxNumberOfTeams(new int[]{2, 4, 6}, 2));
        System.out.println(new MaxNumberOfTeams().maxNumberOfTeams(new int[]{2, 4, 6}, 4));
    }
}
