class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        int ans = 0;
        for(int right =0; right < s.length(); right++) {
            char rightSide = s.charAt(right);
            map.put(rightSide, map.getOrDefault(rightSide, 0) + 1);
            max = Math.max(max, map.get(rightSide));
            int replacement = (right - left + 1) - max;

            if(replacement > k) {
                char leftSide = s.charAt(left);
                map.put(leftSide, map.getOrDefault(leftSide, 0) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1); 
        }
        return ans;
    }
}