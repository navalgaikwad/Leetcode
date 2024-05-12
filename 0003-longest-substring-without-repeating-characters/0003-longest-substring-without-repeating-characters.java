class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int leftIndex = 0;
        int maxLength = 0;
        for(int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            
            char rightChar = s.charAt(rightIndex);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            
            while(map.get(rightChar) > 1) {
                char leftChar = s.charAt(leftIndex);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                leftIndex++;
            }
            
           maxLength = Math.max(maxLength, rightIndex - leftIndex + 1); 
        }
        return maxLength;
    }
}