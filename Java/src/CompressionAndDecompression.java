public class CompressionAndDecompression {
    public static String decompress(String input) {
        if (input == null || input.length() == 0)
            return "";
        StringBuilder res = new StringBuilder();
        while (input.length() > 0) {
            int i1 = input.indexOf('[');
            if (i1 == -1) {
                res.append(input);
                break;
            } else {
                int indexOfDigit = 0;
                while (Character.isLetter(input.charAt(indexOfDigit)))
                    indexOfDigit++;
                // 加入digit之前的部分
                res.append(input, 0, indexOfDigit);
                // 计算括号内重复的次数
                int repeat = Integer.parseInt(input.substring(indexOfDigit, i1));
                // 找到匹配的右括号
                int i2 = i1, count = 1;
                // 只在count非0的时候对i2++，否则停止
                while (count != 0 && ++i2 < input.length()) {
                    if (input.charAt(i2) == '[')
                        count++;
                    else if (input.charAt(i2) == ']')
                        count--;
                }
                // 计算出括号内的字符串
                String tmp = decompress(input.substring(i1 + 1, i2));
                // 对括号内字符串重复repeat次
                for (int i = 0; i < repeat; i++)
                    res.append(tmp);
                // 如果没有到头
                if (i2 + 1 < input.length())
                    input = input.substring(i2 + 1);
                else
                    break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(decompress("2[a5[b]]c2[d]"));
    }
}
