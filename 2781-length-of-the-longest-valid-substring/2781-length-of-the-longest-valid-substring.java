class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        HashSet<String> set = new HashSet<>(forbidden);
        int left =0;
        int len =0;
        for(int right =0; right<word.length(); right++) {
            for(int k = right; k>=Math.max(left, right - 9); k--) {
                if(set.contains(word.substring(k, right+1))) {
                    left= k+1;//move ahead that much of k
                    break;
                }
            }
            len = Math.max(len, right -left + 1);
        }
        return len;
    }
}