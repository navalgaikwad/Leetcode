class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int freq = map.get(s.charAt(0));
        int len = s.length();
        for(int i=0; i<len; i++){
            if(map.get(s.charAt(i))!=freq){
                return false;
            }
        }
        return true;
    }
}