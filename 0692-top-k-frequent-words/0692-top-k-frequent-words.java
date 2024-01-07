class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> q = new PriorityQueue<>((a, b)-> 
        map.get(a)==map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
        q.addAll(map.keySet());
        
        List<String> result = new ArrayList<>();
        while(k >0) {
            result.add(q.remove());
            k--;
        }
        //System.out.print(result);
        return result;
    }
}