class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int right =0; right < s.length(); right++) {
            char rightSide = s.charAt(right);
            map.put(rightSide, map.getOrDefault(rightSide, 0) + 1);
            while(map.get(rightSide) > 1) {
                char leftSide = s.charAt(left);
                map.put(leftSide, map.getOrDefault(leftSide, 0) - 1);
                if(map.get(leftSide) == 0) {
                    map.remove(leftSide);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}