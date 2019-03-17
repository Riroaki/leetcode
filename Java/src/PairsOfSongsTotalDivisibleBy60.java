public class PairOfSongsTotalDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> modCount = new HashMap<>();
        int n = time.length, res = 0;
        for (int num : time) {
            int mod = num % 60;
            if (mod == 0)
                res += modCount.getOrDefault(0, 0);
            else
                res += modCount.getOrDefault(60 - mod, 0);
            modCount.put(mod, modCount.getOrDefault(mod, 0) + 1);
        }
        return res;
    }
}
