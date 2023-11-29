class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = 
            new PriorityQueue<>( (a, b)-> map.get(a) == map.get(b)? a.compareTo(b) : map.get(b) - map.get(a));
        //pq.addAll(map.keySet());
        
        for(String key: map.keySet()) {
            pq.add(key);
        }
        List<String> word = new ArrayList<>();
        while(k-- > 0){
            word.add(pq.remove());
        }
        //Collections.sort(word,);
        return word;
    }
}