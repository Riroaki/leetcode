public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        char[] s1 = num1.toCharArray(), s2 = num2.toCharArray();
        int n1 = s1.length, n2 = s2.length;
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int num = (s1[i] - '0') * (s2[j] - '0');
                res[i + j + 1] += num;
            }
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n1 + n2 - 1; i >= 0; i--) {
            res[i] += carry;
            carry = res[i] / 10;
            sb.append(res[i] % 10);
        }
        sb = sb.reverse();
        int index = 0;
        // length() - 1是避免全0，留个种～
        while (index < sb.length() - 1 && sb.charAt(index) == '0')
            index++;
        return sb.toString().substring(index);
    }
}
