class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b)- map.get(a));
        //pq.add(map.getkey());
        //System.out.print(map.keySet());
        pq.addAll(map.keySet());
        int[] ans = new int[k];
        int i=0;
        while(k-- > 0) {
            ans[i++] = pq.remove();
        }
        return ans;
    }
    
    
}