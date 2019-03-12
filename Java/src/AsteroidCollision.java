import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] a) {
        int n = a.length;
        Stack<Integer> res = new Stack<>();
        for (int num : a) {
            boolean exist = true;
            while (!res.isEmpty() && num < 0 && res.peek() > 0) {
                if (res.peek() + num < 0)
                    res.pop();
                else {
                    exist = false;
                    if (res.peek() + num == 0)
                        res.pop();
                    break;
                }
            }
            if (exist)
                res.push(num);
        }
        int nr = res.size();
        int[] remain = new int[nr];
        for (int i = nr - 1; i >= 0; i--)
            remain[i] = res.pop();
        return remain;
    }
}
