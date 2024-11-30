class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left =0;
        int maxLen =0;
        int freq = 0;
        for(int right = 0; right<s.length(); right++) {
            
            char rightSide = s.charAt(right);
            map.put(rightSide, map.getOrDefault(rightSide, 0) + 1);
            freq = Math.max(freq, map.get(rightSide));
            int replacementsNeeded = (right - left + 1) - freq;
            
            if(replacementsNeeded > k) {
                char leftSide = s.charAt(left);
                map.put(leftSide, map.getOrDefault(leftSide, 0) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        } 
        return maxLen;
    }
}