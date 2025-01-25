class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int shortLength = Integer.MAX_VALUE;
        long sum =0;
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.getKey(), b.getKey())
            );
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if(sum >= k) {
                shortLength = Math.min(shortLength, i + 1);
            }

            while(!pq.isEmpty() && sum - pq.peek().getKey() >= k) {
                shortLength = Math.min(shortLength, i -  pq.poll().getValue());
            }


            pq.offer(new Pair<>(sum, i));
        }
        return shortLength == Integer.MAX_VALUE ? -1 : shortLength;
    }
}