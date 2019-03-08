public class MaskPersonalInfo {
    public String maskPII(String s) {
        int i1 = s.indexOf("@");
        StringBuilder res = new StringBuilder();
        if (i1 >= 0) {
            res.append(Character.toLowerCase(s.charAt(0)));
            res.append("*****");
            res.append(Character.toLowerCase(s.charAt(i1 - 1)));
            for (int i = i1; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if (Character.isLetter(tmp))
                    tmp = Character.toLowerCase(tmp);
                res.append(tmp);
            }
        } else {
            StringBuilder tmp = new StringBuilder();
            for (char c : s.toCharArray())
                if ('0' <= c && '9' >= c)
                    tmp.append(c);
            String tmps = tmp.toString();
            int len = tmps.length();
            if (len > 10) {
                res.append('+');
                for (int i = 10; i < len; i++)
                    res.append('*');
                res.append('-');
            }
            res.append("***-***-");
            res.append(tmps.substring(len - 4, len));
        }
        return res.toString();
    }
}
