class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(Character val : t.toCharArray()) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        int count = map.size();
        int minLen = Integer.MAX_VALUE;
        
        String result = "";
        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1); 
                if(map.get(rightChar) == 0) {
                    count--;
                }
            }
            while(count == 0) {
                if(right - left + 1  < minLen) {
                    minLen = right - left + 1;
                    result= s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)) {
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1); 
                    if(map.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}