class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> pq = new 
            PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
       while (!pq.isEmpty()) {
            char c = pq.remove();
            int k = map.get(c);
            while(k > 0) {
                sb.append(c);
                k--;
            }
        }
        return sb.toString();
    }
}