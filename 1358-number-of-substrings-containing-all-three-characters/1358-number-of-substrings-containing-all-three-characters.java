class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int leftIndex = 0;
        int result = 0;
        for(int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            char rightChar = s.charAt(rightIndex);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            
            while(map.size()>=3) {
                char leftChar = s.charAt(leftIndex);
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                leftIndex++;
            }
            result+=leftIndex;
        }
        return result;
    }
}