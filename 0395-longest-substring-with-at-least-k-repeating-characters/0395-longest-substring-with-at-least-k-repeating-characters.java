class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubString(s, k, 0, s.length() - 1);
    }
    int longestSubString(String s, int k, int start, int end) {
        if(end-start + 1<k) {
            return 0;
        }
        Map<Character, Integer> map =new HashMap<>();
        for(int i = start; i<=end; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=start; i<=end;i++) {
            if(map.get(s.charAt(i)) < k) {
                int left = longestSubString(s, k, start, i - 1);
                int right = longestSubString(s, k, i+1, end);
                return Math.max(left, right);
            }
        }
        return end - start + 1;
    }
}