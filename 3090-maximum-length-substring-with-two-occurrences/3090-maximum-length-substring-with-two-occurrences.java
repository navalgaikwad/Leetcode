class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left =0;
        int maxLen =0;
        for(int right=0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            
            while(map.get(s.charAt(right)) > 2) {
                char leftSide = s.charAt(left);
                map.put(leftSide, map.getOrDefault(leftSide, 0) - 1);
                
                if(map.get(leftSide) == 0) {
                    map.remove(leftSide);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}