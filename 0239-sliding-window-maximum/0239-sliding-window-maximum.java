class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int j =0;
        for(int i = 0; i < nums.length; i++) {
            while(!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                q.removeLast();//remove from last
            }
            q.addLast(i);
            if(q.peek() + k == i) {// window size
                q.removeFirst();
            }
            if( i>= k-1) { //check for answeer it i > k -1
                result[j++] = nums[q.peek()];
            }
        }
        return result;
    }
}