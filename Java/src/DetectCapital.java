public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        boolean firstCapital = Character.isUpperCase(word.charAt(0));
        for (char c : word.toCharArray())
            capitalCount += Character.isUpperCase(c) ? 1 : 0;
        return capitalCount == 0 || capitalCount == word.length()
            || (capitalCount == 1 && firstCapital);
    }
}
