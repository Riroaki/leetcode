public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        int currentDir = 0, currX = 0, currY = 0, currentNum = 1, bound = n * n;
        int[][] res = new int[n][n];
        res[0][0] = 1;
        while (currentNum < bound) {
            int tmpX = currX + dx[currentDir], tmpY = currY + dy[currentDir];
            if (tmpX == n || tmpX == -1 || tmpY == n || tmpY == -1 || res[tmpY][tmpX] != 0) {
                currentDir = (currentDir + 1) % 4;
                currX += dx[currentDir];
                currY += dy[currentDir];
            } else {
                currX = tmpX;
                currY = tmpY;
            }
            res[currY][currX] = ++currentNum;
        }
        return res;
    }

    private static void printMat(int[][] m) {
        for (int[] ints : m) {
            for (int j = 0; j < m[0].length; j++)
                System.out.print(ints[j] + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMat(new SpiralMatrix2().generateMatrix(1));
        printMat(new SpiralMatrix2().generateMatrix(2));
        printMat(new SpiralMatrix2().generateMatrix(4));
    }
}
