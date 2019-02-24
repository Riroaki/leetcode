public class FindCelebrity {
    private boolean knows(int a, int b) {
        return true;
    }

    public int findCelebrity(int n) {
        int res = 0;
        // 循环找，要么res停在中间（应该是真名人），要么就是最后一个（此时可能是假名人）
        for (int i = 1; i < n; i++)
            if (knows(res, i)) res = i;
        // 验证这个名人是不是名人（如果存在名人的话res一定是名人，这里只是排除不存在名人或者异常状况）
        for (int i = 0; i < n; i++)
            if (res != i && (knows(res, i) || !knows(i, res))) return -1;
        return res;
    }
}
