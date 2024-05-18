class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxq = new LinkedList<>();
        Deque<Integer> minq = new LinkedList<>();
        int len =0;
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            while(!maxq.isEmpty() && maxq.getLast() < nums[i]) {
                maxq.removeLast();
            }
            while(!minq.isEmpty() && minq.getLast() > nums[i]) {
                minq.removeLast();
            }
            
            maxq.add(nums[i]);
            minq.add(nums[i]);
            if(maxq.peekFirst() - minq.peekFirst() > limit) {
                if(nums[j] == maxq.peekFirst()) {
                    maxq.removeFirst();
                }
                if(nums[j] == minq.peekFirst()) {
                    minq.removeFirst();
                }
                j++;
            }
            len = Math.max(len, i - j + 1);
        }
        return len;
    }
}