class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words) {
           map.put(word, map.getOrDefault(word, 0) + 1); 
        }
        PriorityQueue<String> pq = 
            new PriorityQueue<>((a,b)-> map.get(b) == map.get(a) ? a.compareTo(b) : 
                                map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        List<String> result = new ArrayList<>();
        while(k > 0) {
           result.add(pq.remove()); 
            k--;
        }
        
        return result;
    }
}