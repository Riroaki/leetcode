public class BeautifulArrangement {
/*
   // Naive version: check all arrangements after they are formed;
   // got TLE when n = 12.
    private boolean[][] modTable;
    private List<Integer> currentNums;
    int res, target;
    
    private boolean isBeautiful(List<Integer> a) {
        int i;
        for(i = 1; i <= a.size(); i++) {
            int num = a.get(i - 1);
            if (!modTable[i][num] && !modTable[num][i])
                return false;
        }
        // System.out.println(a + " is beautiful.");
        return true;
    }
    
    private void findArrangement(List<Integer> arrange) {
        if (arrange.size() == target) {
            // System.out.println(arrange);
            res += isBeautiful(arrange) ? 1 : 0;
        } else {
            for (int index = 0; index < currentNums.size(); index++) {
                // 从current中取出加入arrange
                int num = currentNums.get(index);
                arrange.add(num);
                currentNums.remove(index);
                // 继续寻找
                findArrangement(arrange);
                // 从arrange中取出加回current
                currentNums.add(index, num);
                arrange.remove(arrange.size() - 1);
            }
        }
    }
    
    public int countArrangement(int N) {
        res = 0;
        target = N;
        currentNums = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            currentNums.add(i);
        modTable = new boolean[16][16];
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 16; j++) {
                modTable[i][j] = i % j == 0;
            }
        }
        findArrangement(new ArrayList<>());
        return res;
    }
*/
	// AC version. This is improved by checking the beautifulness of each bit when forming the arrangements.
	// Record all mod results in a mod table.
    private boolean[][] modTable;
    private boolean[] isUsed;
    int res, target;
    
    private void findArrangement(List<Integer> arrange) {
        if (arrange.size() == target)
            res++;
        else {
            int currentPos = arrange.size() + 1;
            for (int index = 1; index <= target; index++) {
                // 从当前数组中取出num加入arrange
                if (isUsed[index])
                    continue;
                if (!modTable[currentPos][index] && !modTable[index][currentPos])
                    continue;
                arrange.add(index);
                isUsed[index] = true;
                // 继续寻找
                findArrangement(arrange);
                // 从arrange中取出num并放回当前数组
                arrange.remove(arrange.size() - 1);
                isUsed[index] = false;
            }
        }
    }
    
    public int countArrangement(int N) {
        res = 0;
        target = N;
        isUsed = new boolean[N + 1];
        modTable = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                modTable[i][j] = i % j == 0;
        findArrangement(new ArrayList<>());
        return res;
    }
}
