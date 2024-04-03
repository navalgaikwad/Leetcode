class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left =0;
        int len = 0;
        for(int right = 0; right < s.length(); right++) {
            char cright = s.charAt(right);
            map.put(cright, map.getOrDefault(cright, 0) + 1);
            while(map.get(cright) > 1) {
                char cleft = s.charAt(left);
                map.put(cleft, map.getOrDefault(cleft, 0) - 1);
                if(map.get(cleft) == 0) {
                    map.remove(cleft);
                }
                left++;
            }
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}
