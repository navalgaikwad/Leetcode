class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int j =0;
        for(int i =0; i<len; i++) {
            while(!q.isEmpty() && nums[i] > nums[q.getLast()]) {
                q.removeLast();
            }
            q.addLast(i);
            if(q.peek()+k == i) {
                q.removeFirst();
            }
            if(i>=k-1) {
                result[j++] = nums[q.peek()];
            }
        }
        return result;
    }
}