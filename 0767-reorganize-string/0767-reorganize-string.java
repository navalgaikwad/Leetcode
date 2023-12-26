class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        pq.addAll(map.keySet()); // sort by frequecy
        String result = "";
        while(pq.size() > 1) {
           char a = pq.remove();
           char b = pq.remove();
            
            result+=a;
            result+=b;
            map.put(a, map.getOrDefault(a, 0) - 1);
            map.put(b, map.getOrDefault(b, 0) - 1);
            if(map.get(a)!=0) {
                pq.add(a);
            }
            if(map.get(b)!=0) {
                pq.add(b);
            }
        }
        if(!pq.isEmpty()){
            Character c= pq.remove(); // if there is remaining if it greater than 1 return null
           if(map.get(c)>1){
               return "";
           }
           result+=c;
        }
        return result;
    }
}