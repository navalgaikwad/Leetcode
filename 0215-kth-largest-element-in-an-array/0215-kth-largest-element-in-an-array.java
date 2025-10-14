class Solution {
    public int findKthLargest(int[] nums, int k) {
          // Max-heap to keep track of k smallest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.remove();  // Remove the largest among k+1
            }
        }

        return pq.peek();  // Top is the kth smallest
    }
}