public class TextJustification {
    // 0ms 100%.
    // 这题需要小心做，虽然比较无聊，但是可能就是那种业务代码……
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int index = 0, n = words.length, currLen = 0, currIndex = 0;
        while (index < n) {
            line.setLength(0);
            currLen = 0;
            currLen += words[index].length();
            while (index + 1 < n && currLen + 1 + words[index + 1].length() <= maxWidth)
                currLen += 1 + words[++index].length();
            int extraSpace = maxWidth - currLen;
            if (index == currIndex) {
                line.append(words[index]);
                while (line.length() < maxWidth)
                    line.append(" ");
            } else if (index < n - 1) {
                // Not last line, center-adjusted.
                int eachSpace = extraSpace / (index - currIndex), left = extraSpace % (index - currIndex);
                int[] tmp = new int[index - currIndex];
                eachSpace++;
                Arrays.fill(tmp, eachSpace);
                for (int i = 0; i < left; i++)
                    tmp[i]++;
                for (int i = currIndex; i <= index; i++) {
                    if (i > currIndex) {
                        for (int j = 0; j < tmp[i - 1 - currIndex]; j++)
                            line.append(" ");
                    }
                    line.append(words[i]);
                }
            } else {
                // Last line, left-adjusted.
                for (int i = currIndex; i <= index; i++) {
                    if (i > currIndex)
                        line.append(" ");
                    line.append(words[i]);
                }
                for (int i = line.length(); i < maxWidth; i++)
                    line.append(" ");
            }
            res.add(line.toString());
            currIndex = ++index;
        }
        return res;
    }
}
