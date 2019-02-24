public class BrokenCalculator {
    // 这道题非常非常巧妙，神了！
    // 首先，正面直接做的话采用递归（记忆化搜索，如果设置不好上限容易溢出或者达不到）

    // 所以采用从Y到X的做法，对X的-1和X2，对Y则是+1和/2
    // 然后，当Y小于X的时候，自然不可能使用/2，所以只要加到X为止；

    // 在计算过程中，不可能出现连续的两次+1，因为(y+1+1)/2=y+1，次数变多了
    // 而在计算过程中，对于Y是偶数的时候，对Y+1再/2会导致加的1损失(2n+1)/2=n，这一次是多余的，所以在Y是偶数的时候，直接/2就可以

    // 对称的，在计算过程中，对于Y是奇数的时候，因为我们需要的是X如何变成Y，而X变成Y的最后一步肯定不是X2（注意Y是奇数）
    // 那么这个时候，逻辑上只能对Y+1
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            res++;
        }
        return res + X - Y;
    }

    public static void main(String[] args) {
        System.out.println(new BrokenCalculator().brokenCalc(2, 3));
        System.out.println(new BrokenCalculator().brokenCalc(5, 8));
    }
}
