class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int result =0;
        Map<Character, Integer> map= new HashMap<>();
        for(int right=0; right<s.length(); right++) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            while(map.get(rightChar)>1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}