class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
    
//     int pivotIndex(int[] nums, int start, int end) {
//         int pivot = nums[end];
//         while() {
            
//         }
//     }
}

