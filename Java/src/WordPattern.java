public class WordPattern {
    // use 2 maps to keep the one-to-one relation between string and character
    // We can also keep the relation by mapping the both to a same integer.
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map<Character, String> chStr = new HashMap<>();
        Map<String, Character> strCh = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            String s = words[i];
            if (!chStr.containsKey(ch)
               && !strCh.containsKey(s)) {// 两个都没有注册
                chStr.put(ch, s);
                strCh.put(s, ch);
            } else if (chStr.containsKey(ch)
                      && strCh.containsKey(s)) {// 两个都注册了
                if (!chStr.get(ch).equals(s) || !strCh.get(s).equals(ch))
                    return false;
            } else// 一个被注册了
                return false;
        }
        return true;
    }
}
