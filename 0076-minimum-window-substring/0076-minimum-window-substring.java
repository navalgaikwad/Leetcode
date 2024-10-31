class Solution {
    public String minWindow(String s, String t) {
        int left =0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int size = map.size();
        int min = Integer.MAX_VALUE;
        String result = "";
        for(int right =0; right<s.length(); right++) {
            char rightChar = s.charAt(right);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
                if(map.get(rightChar) == 0) {
                    size--;
                 
                }
            }
            while(size == 0) {
                if(right - left + 1 < min) {
                    min = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                 char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)) {
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                    if(map.get(leftChar) > 0) {
                        size++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}