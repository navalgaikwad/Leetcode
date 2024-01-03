
  class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[Math.max(m, n) + 1];
        int i = m - 1, j = n - 1, k = pos.length - 1;

        while (i >= 0 || j >= 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + pos[k];
            pos[k] = sum % 10;
            pos[k - 1] += sum / 10;
            i--;
            j--;
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
