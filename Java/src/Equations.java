import java.util.Arrays;

public class Equations {
    public boolean equationsPossible(String[] equations) {
        if (equations.length < 2) return true;
        int[][] equalMatrix = new int[26][26];
        for (int i = 0; i < 26; i++) equalMatrix[i][i] = 1;
        for (String eq : equations) {
            int left = eq.charAt(0) - 'a', right = eq.charAt(3) - 'a';
            int isEqual = eq.charAt(1) == '=' ? 1 : -1;
            if (equalMatrix[left][right] == 0) {
                equalMatrix[left][right] = isEqual;
                equalMatrix[right][left] = isEqual;
                int[] copyRight = Arrays.copyOf(equalMatrix[right], 26), copyLeft = Arrays.copyOf(equalMatrix[left], 26);
                for (int i = 0; i < 26; i++) {
                    if (i != left && copyRight[i] != 0) {
                        equalMatrix[left][i] = equalMatrix[right][i] * isEqual;
                        equalMatrix[i][left] = equalMatrix[left][i];
                    }
                    if (i != right && copyLeft[i] != 0) {
                        equalMatrix[right][i] = equalMatrix[left][i] * isEqual;
                        equalMatrix[i][right] = equalMatrix[right][i];
                    }
                }
            } else if (equalMatrix[left][right] != isEqual)
                return false;
        }
        return true;
    }
//    public boolean equationsPossible(String[] equations) {
//        if (equations.length < 2) return true;
//        int[] values = new int[26];
//        boolean satisfiable = true;
//        for (int i = 0; i < 26; i++) values[i] = -1;
//        for (String eq : equations) {
//            int left = eq.charAt(0) - 'a', right = eq.charAt(3) - 'a';
//            boolean isEqual = eq.charAt(1) == '=';
//            if (values[left] != -1 && values[right] != -1) {
//                boolean tmp = values[left] == values[right];
//                if (tmp != isEqual) {
//                    satisfiable = false;
//                    break;
//                }
//            } else if (isEqual) {
//                if (left == right) continue;
//                if (values[left] != -1) values[right] = values[left];
//                else if (values[right] != -1) values[left] = values[right];
//                else values[left] = values[right] = left;
//            } else {
//                if (left == right) {
//                    satisfiable = false;
//                    break;
//                }
//                if (values[left] != -1) values[right] = right;
//                else if (values[right] != -1) values[left] = left;
//                else {
//                    values[left] = left;
//                    values[right] = right;
//                }
//            }
//        }
//        return satisfiable;
//    }

    public static void main(String[] args) {
//        System.out.println(new Equations().equationsPossible(new String[]{"b==a", "a==b"}));                            // T
//        System.out.println(new Equations().equationsPossible(new String[]{"a==b", "b==c", "a==c"}));                    // T
//        System.out.println(new Equations().equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));                    // F
//        System.out.println(new Equations().equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));                    // T
//        System.out.println(new Equations().equationsPossible(new String[]{"c==c", "f!=a", "f==b", "b==c"}));            // T
//        System.out.println(new Equations().equationsPossible(new String[]{"e==d", "e==a", "f!=d", "b!=c", "a==b"}));    // T
        System.out.println(new Equations().equationsPossible(new String[]{"a!=i", "g==k", "k==j", "k!=i", "c!=e", "a!=e", "k!=a", "a!=g", "g!=c"}));// T
    }
}
