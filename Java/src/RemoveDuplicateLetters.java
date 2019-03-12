import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicate(String s) {
        char[] ch = s.toCharArray();
        int[] count = new int[26];
        boolean[] recorded = new boolean[26];
        Stack<Character> res = new Stack<>();
        for (char c : ch)
            count[c - 'a']++;
        for (char c : ch) {
            if (recorded[c - 'a'])
                continue;
            count[c - 'a']--;
            // 精华所在：如果栈中的字母比当前字母大而且在之后的序列中还有出现
            // 那么就先不把它加入栈。
            while (!res.isEmpty() && res.peek() > c && count[res.peek() - 'a'] > 0)
                recorded[res.pop() - 'a'] = false;
            recorded[c - 'a'] = true;
            res.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty())
            sb.append(res.pop());
        return sb.reverse().toString();
    }
}
