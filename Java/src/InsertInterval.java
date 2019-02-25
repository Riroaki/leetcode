import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class InsertInterval {
    // Elegant的做法。只可意会不可言传……自己领悟吧
    // 另外，如果返回类型是void，那么应该是在原数组修改；但是这里返回List，应该需要生成一个新的数组。
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (newInterval == null || interval.end < newInterval.start)
                res.add(interval);
            else if (newInterval.end < interval.start) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
                // 注意，这里还不能直接加上去，等到之后遇到能够直接加的时候再加
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res;
    }

    // In place solution.上面那个的就地修改版本
    public void insertInPlace(List<Interval> intervals, Interval newInterval) {
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval == null || intervals.get(i).end < newInterval.start) continue;
            if (newInterval.end < intervals.get(i).start) {
                intervals.add(i, newInterval);
                break;
            } else {
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            }
        }
        if (newInterval != null) intervals.add(newInterval);
    }

    public static void main(String[] args) {
        List<Interval> a = new ArrayList<>();
        a.add(new Interval(1, 3));
        a.add(new Interval(6, 9));
        a = new InsertInterval().insert(a, new Interval(2, 5));
        for (Interval interval : a) System.out.println(interval.start + "," + interval.end);
    }
}
