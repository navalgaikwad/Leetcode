class Solution {
    //"abcabcbb"
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int max =0;
        int left =0;
        for(int right = 0; right<len; right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while(map.get(s.charAt(right)) > 1) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if(map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}