public class DecodeString {
    // 我的妈诶，好久没有一次过了，还1ms 100%，开心😄
    // 其实还有一个规定没有明说：如果用了括号那么默认前面是数字，不然你这括号是不是意义啊？
    public String decodeString(String s) {
        int n = s.length(), index = s.indexOf("[");
        StringBuilder res = new StringBuilder();
        if (n == 0)
            return "";
        // 处理没有括号的字符串
        if (index < 0) {
            index = 0;
            int digitEnd = index, strEnd, mul;
            while (digitEnd < n && Character.isDigit(s.charAt(digitEnd)))
                digitEnd++;
            if (digitEnd == index)
                mul = 1;
            else
                mul = Integer.parseInt(s.substring(index, digitEnd));
            strEnd = digitEnd;
            while (strEnd < n && Character.isLetter(s.charAt(strEnd)))
                strEnd++;
            String tmp = s.substring(digitEnd, strEnd);
            for (int i = 0; i < mul; i++)
                res.append(tmp);
        } else {
            // 处理有括号的字符串：递归处理
            int digitStart = index - 1;
            while (digitStart >= 0 && Character.isDigit(s.charAt(digitStart)))
                digitStart--;
            digitStart++;
            int mul = Integer.parseInt(s.substring(digitStart, index));
            res.append(s.substring(0, digitStart));// 处理括号前面的字符串
            int balance = 1, right = index;// 由于括号可能存在嵌套，所以需要找到匹配的括号
            while (balance != 0) {
                right++;
                if (s.charAt(right) == '[')
                    balance++;
                else if (s.charAt(right) == ']')
                    balance--;
            }
            String tmp = decodeString(s.substring(index + 1, right));
            for (int i = 0; i < mul; i++)
                res.append(tmp);// 处理括号内字符串
            res.append(decodeString(s.substring(right + 1)));// 处理括号后面字符串
        }
        return res.toString();
    }
}
