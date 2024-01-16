class Solution {
    //slidding window
    //insider loop for(int k=right; k>=Math.max(left, right - 9); k--) {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> set = new HashSet<>(forbidden);
        int left=0;
        int right =0;
        int n = word.length();
        int ans =0;
        for(;right<n; right++) {
            for(int k=right; k>=Math.max(left, right - 9); k--) {
                if(set.contains(word.substring(k, right+1))) {
                    left = k +1;
                    break;
                }
            }
            ans = Math.max(right - left + 1, ans);
            //right++;
        }
        return ans;
    }
}