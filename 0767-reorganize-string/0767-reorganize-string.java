class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        String result = "";
        while(pq.size()>1) {
            char one = pq.remove();
            char two = pq.remove();
            result+=one;
            result+=two;
            map.put(one, map.getOrDefault(one, 0) - 1);
            map.put(two, map.getOrDefault(two, 0) - 1);
            if(map.get(one) != 0) {
                pq.add(one);
            }
            if(map.get(two) != 0) {
                pq.add(two);
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