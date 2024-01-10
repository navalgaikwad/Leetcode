import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder ans = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
    // Signs are different
    ans.append('-');
}


        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long q = num / den;
        long r = num % den;
        ans.append(q);

        if (r == 0) return ans.toString();

        ans.append('.');
        Map<Long, Integer> mp = new HashMap<>();
        while (r != 0) {
            if (mp.containsKey(r)) {
                int pos = mp.get(r);
                ans.insert(pos, '(');
                ans.append(')');
                break;
            } else {
                mp.put(r, ans.length());
                r *= 10;
                q = r / den;
                r = r % den;
                ans.append(q);
            }
        }
        return ans.toString();
    }
}
