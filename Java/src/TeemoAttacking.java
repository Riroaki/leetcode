public class TeemoAttacking {
    // curr表示当前最后一次开始中毒的时间
    // 在中毒时间内再次中毒，不会叠加，只是刷新了中毒时长，相当于上一个状态解除，进入新的中毒状态
    // 不难，但是要思考清楚
    public int findPoisonedDuration(int[] times, int duration) {
        if (duration <= 0 || times.length == 0)
            return 0;
        int curr = times[0], res = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[i] >= curr + duration) {
                res += duration;
                curr = times[i];
            } else {
                res += times[i] - curr;
                curr = times[i];
            }
        }
        return res + duration;
    }
}
