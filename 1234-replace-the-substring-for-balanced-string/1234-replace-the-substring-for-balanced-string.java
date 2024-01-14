class Solution {
    public int balancedString(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            ++count[c];
        }
        int left = 0;
        int k = s.length() / 4;
        int len = s.length();
        for (int right = 0; right < s.length(); right++) {
            --count[s.charAt(right)];
            while (left < s.length() && count['Q'] <= k && count['W'] <= k && count['E'] <= k&& count['R'] <= k) {
                len = Math.min(len, right - left + 1);
                ++count[s.charAt(left)];
                left++;
            }
        }
        return len;
    }
}
// public int balancedString(String s) {
//         int[] count = new int[128];
//         int n = s.length(), res = n, i = 0, k = n / 4;
//         for (int j = 0; j < n; ++j) {
//             ++count[s.charAt(j)];
//         }
//         for (int j = 0; j < n; ++j) {
//             --count[s.charAt(j)];
//             while (i < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
//                 res = Math.min(res, j - i + 1);
//                 ++count[s.charAt(i++)];
//             }
//         }
//         return res;
//     }