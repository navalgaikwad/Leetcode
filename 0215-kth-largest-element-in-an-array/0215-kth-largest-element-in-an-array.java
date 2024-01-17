class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int num : nums) {
            pq.add(num);
        }
        while(k > 1) {
            pq.remove();
            k--;
        }
        return pq.peek();
    }
}