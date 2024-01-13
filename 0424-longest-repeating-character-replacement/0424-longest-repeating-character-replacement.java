class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
       
        int max = 0;
        int ans =0;
        for(int right = 0; right<s.length(); right++) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            max = Math.max(max, map.get(rightChar));
            int replacement = (right - left + 1) - max;//outoff 4 length 1 replacement is allowed 3 is maxFreq of A and 1 B
            if(replacement > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
           ans = Math.max(ans, right - left + 1); 
        }
        return ans;
    }
}

