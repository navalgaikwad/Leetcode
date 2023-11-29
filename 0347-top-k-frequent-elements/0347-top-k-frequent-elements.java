class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) -map.get(b));
        for(Integer m: map.keySet()) {
            pq.add(m);
            while(pq.size() > k){
                pq.remove();
            }
        }
        int[] array = new int[pq.size()];
        int i = 0;
        for (Integer integer : pq) {
            array[i] = integer;
            i++;
        }
        return array;
    }
}