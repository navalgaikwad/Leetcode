class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        Map<Integer, Integer> map =new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        
        int[] result = new int[k];
        k = k - 1;
        int i =0;
        while(k>=0){
            result[i++] = pq.remove();
            k--;
        }
        return result;
    }
}

