class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result  =0;
        int left =0 ;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right<s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while(right<s.length()&& map.get(s.charAt(right))>1) {
               map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
               if( map.get(s.charAt(left))==0) {
                  map.remove(s.charAt(left));
               }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}

//define a map
//when ever i get character value greater than 2 i will decrement window size