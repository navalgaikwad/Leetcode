class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int left =0;
        for(int right =0; right<s2.length(); right++) {
            char rightChar = s2.charAt(right);
            if(map.containsKey(rightChar)) {
                map.put(rightChar, map.getOrDefault(rightChar, 0) - 1);
                if(map.get(rightChar) == 0) {
                    counter--;
                }
            }
            
            while(counter == 0) {
                if(right - left + 1 == s1.length()){
                    return true;
                }
                char leftChar = s2.charAt(left);
                if(map.containsKey(leftChar)) { 
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                    if(map.get(leftChar) > 0) {
                        counter++;
                        
                    }
                }
                left++;
            }
        }
        return false;
    }
}