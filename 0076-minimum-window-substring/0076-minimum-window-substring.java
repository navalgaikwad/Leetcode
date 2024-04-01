class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int len = s.length();
        //int right = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
         for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
                if(map.get(rightChar) == 0) {
                    count--;
                }
            }
            
            while(count == 0) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                char cl = s.charAt(left);
                if(map.containsKey(cl)) {
                    map.put(cl, map.getOrDefault(cl, 0) + 1);
                    if(map.get(cl) > 0) {
                      count++;
                    }
                }
                left++;
            }
            
        }
        return ans;
    }
}

/*
s = "ADOBECODEBANC", t = "ABC"
A:1
B:1
C:1

Jwhen ever it is 0
if min len updadet the window
get left char check if present in map then increament


*/