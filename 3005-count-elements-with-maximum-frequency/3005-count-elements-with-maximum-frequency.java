class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalCount =0;
        int max = 0;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)  + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.addAll(map.values());
        while(!pq.isEmpty()) {
            int num = pq.remove();
            
            if(num > max) {
                totalCount = num;
                max = num;
            }else if(max == num) {
                totalCount+=num;
            }
        }
        return totalCount;
    }
}