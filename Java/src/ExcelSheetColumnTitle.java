public class ExcelSheetColumnTitle {
    // 我佛了，这题目。。。和一般的进制转换又不一样，还说不出来那里有问题。。
    // 记住就完事了= =
    public String convertToTitle(int n) {
        if(n <= 0) return "";
        StringBuilder res = new StringBuilder();
        while(n>0) {
            n--;// 这一步是关键！
            res.append((char)(n%26+'A'));
            n/=26;
        }
        return res.reverse().toString();
    }
}
