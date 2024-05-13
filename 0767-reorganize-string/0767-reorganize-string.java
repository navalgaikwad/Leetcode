class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        
        String result = "";
        while(pq.size() > 1) {
            char characterOne = pq.remove();
            char characterTwo = pq.remove();
            
            result+=characterOne;
            result+=characterTwo;
            
            map.put(characterOne, map.getOrDefault(characterOne, 0) - 1);
            map.put(characterTwo, map.getOrDefault(characterTwo, 0) - 1);
            if(map.get(characterOne) != 0) {
                pq.add(characterOne);
            }
            
            if(map.get(characterTwo) != 0) {
                pq.add(characterTwo);
            }
        }
        
        if(!pq.isEmpty()) {
            Character c= pq.remove(); // if there is remaining if it greater than 1 return null
           if(map.get(c)>1){
               return "";
           }
           result+=c;
        }
        return result;
    }
}