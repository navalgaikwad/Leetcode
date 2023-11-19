class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxSoFar = 0;
        for(int right = 0; right < s.length(); right++){
            char value  = s.charAt(right);
            while(set.contains(value)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(value);
           // System.out.print(set);
            maxSoFar = Math.max(maxSoFar, right - left + 1);
        }
        return maxSoFar; //pw
    }
}