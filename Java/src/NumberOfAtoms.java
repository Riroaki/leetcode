import java.util.*;

public class NumberOfAtoms {
    private HashMap<String, Integer> helper(String s) {
        if (s.length() == 0)
            return new HashMap<>();
        int i1 = s.indexOf('('), n = s.length();
        HashMap<String, Integer> res = new HashMap<>();
        // Deal with '(' and ')'
        if (i1 >= 0) {
            int j1 = i1, count = 0;
            for (; j1 < n; j1++) {
                if (s.charAt(j1) == '(')
                    count++;
                else if (s.charAt(j1) == ')')
                    count--;
                if (count == 0)
                    break;
            }
            int i2 = j1 + 1, j2 = i2;
            while (j2 < n && Character.isDigit(s.charAt(j2)))
                j2++;
            HashMap<String, Integer> before = helper(s.substring(0, i1)),
                tmp = helper(s.substring(i1 + 1, j1)),
                after = helper(s.substring(j2));
            count = Integer.parseInt(s.substring(i2, j2));
            // Merge the 3 maps
            for (Map.Entry<String, Integer> entry : tmp.entrySet())
                res.put(entry.getKey(), entry.getValue() * count);
            for (Map.Entry<String, Integer> entry : before.entrySet())
                res.put(entry.getKey(), res.getOrDefault(entry.getKey(), 0) + entry.getValue());
            for (Map.Entry<String, Integer> entry : after.entrySet())
                res.put(entry.getKey(), res.getOrDefault(entry.getKey(), 0) + entry.getValue());
        } else {
            // Deal with normal atoms
            int curr = 0, j1 = 0, count;
            i1 = 0;
            while (curr < n) {
                while (curr < n - 1 && Character.isLowerCase(s.charAt(curr + 1)))
                    curr++;
                j1 = ++curr;
                String key = s.substring(i1, j1);
                if (curr == n || Character.isUpperCase(s.charAt(curr))) {
                    count = 1;
                } else {
                    while (curr < n && Character.isDigit(s.charAt(curr)))
                        curr++;
                    count = Integer.parseInt(s.substring(j1, curr));
                }
                res.put(key, res.getOrDefault(key, 0) + count);
                i1 = curr;
            }
        }
        return res;
    }
    
    public String countOfAtoms(String formula) {
        HashMap<String, Integer> atomSet = helper(formula);
        List<String> atomList = new ArrayList<>(atomSet.keySet());
        Collections.sort(atomList);
        StringBuilder res = new StringBuilder();
        for (String s : atomList) {
            res.append(s);
            int count = atomSet.get(s);
            if (count > 1)
                res.append(count);
        }
        return res.toString();
    }
}
