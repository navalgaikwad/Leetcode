class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int left =0;
        int len =n;
        int[] counts = new int[128];
        int k = n/4;
        for(char c : s.toCharArray()) {
            counts[c]++;
        }
        for(int right =0; right<n; right++) {
            counts[s.charAt(right)]--;
            while(left < n && counts['Q'] <= k && counts['W'] <= k && counts['E'] <= k&& counts['R'] <= k) {
                len = Math.min(len, right - left + 1);
                counts[s.charAt(left)]++;
                left++;
            }
        }
        return len;
    }
}