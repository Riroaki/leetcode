import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        res.add(S);
        int tip = 1 << 5;
        for (int i = 0; i < S.length(); i++) {
            if (!Character.isLetter(S.charAt(i)))
                continue;
            for (int j = 0, bound = res.size(); j < bound; j++) {
                char[] tmp = res.get(j).toCharArray();
                // Toggle case for char at i.
                // 这里非常巧妙，使用异或实现了大小写反转
                tmp[i] ^= tip;
                res.add(String.valueOf(tmp));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1B2"));
    }
}
