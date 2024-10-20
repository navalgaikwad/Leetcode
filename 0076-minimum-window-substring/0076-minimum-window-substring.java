class Solution {
    public String minWindow(String s, String t) {
        int left =0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            
        }
        int count =map.size();
        int len = Integer.MAX_VALUE;
        String result = "";
        for(int right =0; right < s.length(); right++) {
            char rightSide = s.charAt(right);
            if(map.containsKey(rightSide)) {
                map.put(rightSide, map.getOrDefault(rightSide, 0) - 1);
                if(map.getOrDefault(rightSide, 0) == 0) {
                    count--;
                }
                
            }
            
            
            while(count == 0) {
                if(right - left + 1 < len) {
                    len = right - left + 1;
                    result = s.substring(left, right+1);
                }
                char leftSide = s.charAt(left);
                if(map.containsKey(leftSide)) {
                    map.put(leftSide, map.getOrDefault(leftSide, 0) + 1);
                     if(map.get(leftSide) >0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}