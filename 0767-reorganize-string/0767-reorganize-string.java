class Solution {
    public String reorganizeString(String s) {
       
        Map<Character, Integer> map = new HashMap<>();
        for(char va: s.toCharArray()){
            map.put(va, map.getOrDefault(va, 0)+ 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        pq.addAll(map.keySet()); // sort by frequecy
        
        StringBuilder sb = new StringBuilder();
        while(pq.size()>1){ // pq size is greater than 1
            Character first = pq.remove(); // remove first
            Character second = pq.remove();// remove second
            
            sb.append(first);// append to ans
            sb.append(second);//appenf to ans
            
            map.put(first, map.get(first) - 1); // update the count
            map.put(second, map.get(second) - 1);//update the count
            
            if(map.get(first)>=1){ // if frequncy is greater than 1 
                pq.add(first);
            }
             if(map.get(second)>=1){// if frequncy is greater than 1 
                pq.add(second);
            }
        }
        if(!pq.isEmpty()){
            Character c= pq.remove(); // if there is remaining if it greater than 1 return null
           if(map.get(c)>1){
               return "";
           }
           sb.append(c);
        }
        return sb.toString();
    }
}
//aab
//aba

//aaab
//abaa
//counting