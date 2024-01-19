class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int j =0;
        for(int i=0; i<nums.length; i++) {
            while(q.size() >0 && nums[i] > nums[q.getLast()]) {
                q.removeLast();
            }
            
            q.addLast(i);
            if(q.peek() + k == i){
               q.removeFirst(); 
            }
            if( i>=k-1) {
                result[j] = nums[q.peek()];
                j++;
            }
        }
        return result;
    }
}