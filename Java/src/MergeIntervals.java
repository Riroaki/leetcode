public class MergeIntervals {
    // Naive version by sorting.
    // O(n log n).
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0)
            return new ArrayList<>();
        Collections.sort(intervals, (o1, o2) -> (o1.start - o2.start));
        List<Interval> res = new ArrayList<>();
        int currS = intervals.get(0).start, currE = intervals.get(0).end;
        for (int i = 1; i < n; i++) {
            Interval tmp = intervals.get(i);
            if (tmp.start <= currE) {
                currE = Math.max(currE, tmp.end);
            } else {
                res.add(new Interval(currS, currE));
                currS = tmp.start;
                currE = tmp.end;
            }
        }
        res.add(new Interval(currS, currE));
        return res;
    }
}
