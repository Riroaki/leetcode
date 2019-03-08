public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        res.add("");
        String[] keys = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (char c : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String s : res) {
                for (char d : keys[c - '2'].toCharArray())
                    tmp.add(s + String.valueOf(d));
            }
            res = tmp;
        }
        return res;
    }
}
