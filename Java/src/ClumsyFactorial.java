public class ClumsyFactorial {
    public int clumsy(int N) {
        int curr = N, res = 0;
        while (curr > 0) {
            int tmp = curr == N ? curr : -curr;
            curr--;
            if (curr > 0)
                tmp *= curr--;
            if (curr > 0)
                tmp /= curr--;
            res += tmp;
            if (curr > 0)
                res += curr--;
        }
        return res;
    }
}
