public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        target++;// trick 1
        int lo = 0, hi = letters.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] < target)
                lo = mi + 1;
            else
                hi = mi;
        }
        // Wrap around trick 2.
        return letters[lo] < target ? letters[0] : letters[lo];
    }
}
