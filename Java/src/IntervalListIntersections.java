import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class IntervalListIntersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int i = 0, j = 0;
        List<Interval> tmp = new ArrayList<>();
        int boundA = A.length, boundB = B.length;
        if(boundA == 0 || boundB == 0) return new Interval[]{};
        while (i < boundA && j < boundB) {
            if (A[i].end < B[j].start) i++;
            else if (A[i].start > B[j].end) j++;
            else {
                int[] temp = {A[i].start, A[i].end, B[j].start, B[j].end};
                Arrays.sort(temp);
                tmp.add(new Interval(temp[1], temp[2]));
                if(A[i].end > B[j].end) j++;
                else i++;
            }
        }
        Interval[] res = new Interval[tmp.size()];
        for (int k = 0; k < tmp.size(); k++) res[k] = tmp.get(k);
        return res;
    }

    public static void main(String[] args) {
    }
}
