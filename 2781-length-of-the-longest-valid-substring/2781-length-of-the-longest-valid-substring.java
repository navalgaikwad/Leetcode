import java.util.HashSet;
import java.util.List;

public class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> set = new HashSet<>();
        for (String s : forbidden) {
            set.add(s);
        }

        int n = word.length();
        int ans = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            for (int k = right; k >= Math.max(left, right - 9); k--) {
                if (set.contains(word.substring(k, right + 1))) {
                    left = k + 1;
                    break;
                }
            }
            ans = Math.max(right - left + 1, ans);
            right++;
        }

        return ans;
    }
}
