class Solution {
     public String reorganizeString(String s) {
         if(s.length() == 0) {
             return "";
         }
        Map<Character, Integer> map = new HashMap<>();
         for(char c : s.toCharArray()) {
             map.put(c, map.getOrDefault(c, 0)  +1);
         }
         PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
         pq.addAll(map.keySet());//a, b
         StringBuilder sb = new StringBuilder();
         while(pq.size() > 1) {// it should be greater than one
             char value1 = pq.remove();//a
             char value2 = pq.remove();//b
             
             map.put(value1, map.getOrDefault(value1, 0) - 1);//a = 2
             map.put(value2, map.getOrDefault(value2, 0) - 1);//b = 0
             
             sb.append(value1);//ab
             sb.append(value2);
             if(map.get(value1) > 0) {//
                 pq.add(value1);//a
             }
             if(map.get(value2) > 0) {
                 pq.add(value2);
             }
         }
         
         if(!pq.isEmpty()) {
             char value = pq.remove();//a
             if(map.get(value) > 1) { //2 >1
                 return "";
             }
             sb.append(value);//
         }
         return sb.toString();
    }
}