class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map =new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int count =  map.get(s.charAt(0));
        for(char ch: s.toCharArray()){
            if(count !=  map.get(ch)){
                return false;
            }
        }
        return true;    
    }
}