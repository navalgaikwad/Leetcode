class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
           map.put(num, map.getOrDefault(num, 0) +1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        int n = k;
        int[] ans = new int[n];
        for(int i=0;i<n; i++){
            ans[i] = pq.remove();
        }
        return ans;
    }
}