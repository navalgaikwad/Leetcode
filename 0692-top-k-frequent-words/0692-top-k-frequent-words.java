class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String wrd :words) {
            map.put(wrd, map.getOrDefault(wrd, 0) + 1);
        }
        
        PriorityQueue<String> pq = 
            new PriorityQueue<>((a, b)-> map.get(a) == map.get(b) ? a.compareTo(b) :
                               map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        
        List<String> result = new ArrayList<>();
        while(k-->0) {
            result.add(pq.remove());
        }
        return result;
    }
}