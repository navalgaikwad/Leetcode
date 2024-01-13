class Solution {
    public int longestSubstring(String s, int k) {
        return longestSub(s, k, 0, s.length() - 1);
    }
    
    int longestSub(String s, int k, int start, int end) {
        if(end - start + 1 < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int  i = start; i <= end; i++) {
            char c = s.charAt(i);
            if(map.get(c) < k) {
                int left = longestSub(s, k, start, i - 1);
                int right = longestSub(s, k, i + 1, end);
                return Math.max(left, right);
            }
        }
        return end - start + 1;
    }
}