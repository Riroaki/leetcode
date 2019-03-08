public class ZigZagConversion {
    // 这题真的，很无聊。
        // 取n个stringbuilder代表n行
        // 每次，取下一个字符，轮流放到每个sb里面
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int n = s.length(), curr = 1, currRow = 1, currDir = 1;
        char[] str = s.toCharArray();
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder();
        rows[0].append(str[0]);
        while (curr < n) {
            if (currRow == numRows - 1 || currRow == 0)
                currDir *= -1;
            rows[currRow].append(str[curr++]);
            currRow += currDir;
        }
        for (int i = 1; i < numRows; i++)
            rows[0].append(rows[i]);
        return rows[0].toString();
    }
}
