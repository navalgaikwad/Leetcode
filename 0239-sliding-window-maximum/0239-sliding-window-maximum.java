class Solution {
    //to do
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new LinkedList<>();
        int[] result = new int[nums.length - k +1];
        int j =0;
        for(int i=0; i<nums.length; i++) {
            while( deq.size() >0 &&nums[i] > nums[deq.getLast()]){
                deq.removeLast();
            }
            deq.addLast(i);
            //check for window size
            if(deq.peek() + k == i){
               deq.removeFirst(); 
            }
            if(i >= k-1){
                result[j++] = nums[deq.getFirst()]; 
            }
            
        }
        return result;
    }
}