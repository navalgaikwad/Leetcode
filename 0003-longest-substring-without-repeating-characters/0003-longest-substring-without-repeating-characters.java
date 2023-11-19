class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int len = s.length();
        for(int right = 0; right< len; right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while(map.get(s.charAt(right)) > 1)  {
                int counter = map.get(s.charAt(left));
                map.put(s.charAt(left), counter - 1 );
                left++;
            }
            max = Math.max(max, right - left +1);
        }
        return max;
    }
}