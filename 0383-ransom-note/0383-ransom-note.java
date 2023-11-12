class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character mag: magazine.toCharArray()){
            map.put( mag, map.getOrDefault(mag, 0) + 1);
        }
        
        for(Character ran: ransomNote.toCharArray()){
            if(map.containsKey(ran)){
                 map.put(ran, map.getOrDefault(ran, 0) - 1);
                if(map.get(ran) == 0){
                    map.remove(ran);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}