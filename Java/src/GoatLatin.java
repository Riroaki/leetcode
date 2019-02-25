public class GoatLatin {
    public String toGoatLatin(String s) {
        StringBuilder res = new StringBuilder(), end = new StringBuilder("maa");
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            c = Character.toLowerCase(c);
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                res.append(words[i].substring(1));
                res.append(words[i], 0, 1);
            } else res.append(words[i]);
            res.append(end);
            end.append("a");
            if (i != words.length - 1) res.append(" ");
        }
        return res.toString();
    }
}
