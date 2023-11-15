class Solution {
    //counting
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map=new HashMap<>();
        for(int i=0; i<words.length; i++){
             map.put(words[i],map.getOrDefault(words[i], 0)+1);
            
        }
        System.out.print(map);
        PriorityQueue<String> pq =new PriorityQueue<>((a,b)->map.get(b)!=map.get(a) ? map.get(b)-map.get(a) : a.compareTo(b));      
        pq.addAll(map.keySet());
        System.out.print(pq);
        List<String> ans=new ArrayList<>();
        for(int i=0; i<k; i++){
            System.out.print(pq.peek());
            ans.add(pq.poll());
        }
        return ans;
    }
}