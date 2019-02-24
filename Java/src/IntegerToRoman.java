import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    private String repeat(String a, int time) {
        if (time <= 0)
            return "";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < time; i++)
            res.append(a);
        return res.toString();
    }

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        Map<Integer, String> charSet = new HashMap<>();
        charSet.put(1, "I");
        charSet.put(5, "V");
        charSet.put(10, "X");
        charSet.put(50, "L");
        charSet.put(100, "C");
        charSet.put(500, "D");
        charSet.put(1000, "M");
        res.append(repeat(charSet.get(1000), num / 1000));
        // res.append(charSet.get(1000).repeat(num / 1000)); // since JDK 11
        num %= 1000;
        int base = 100;
        while (base > 0) {
            switch (num / base) {
                case 9:
                    res.append(charSet.get(base));
                    res.append(charSet.get(base * 10));
                    break;
                case 8:
                case 7:
                case 6:
                case 5:
                    res.append(charSet.get(base * 5));
                    res.append(repeat(charSet.get(base), num / base - 5));
                    // res.append(charSet.get(base).repeat(num / base - 5)); // since JDK 11
                    break;
                case 4:
                    res.append(charSet.get(base));
                    res.append(charSet.get(base * 5));
                    break;
                default:
                    res.append(repeat(charSet.get(base), num / base));
                    // res.append(charSet.get(base).repeat(num / base)); // since JDK 11
            }
            num %= base;
            base /= 10;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        for (int i : new int[]{1994, 3999})
            System.out.println(new IntegerToRoman().intToRoman(i));
    }
}
