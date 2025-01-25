class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer>max = new Stack<>();
        int second = Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] < second) {
                return true;
            }
            while(!max.isEmpty() && nums[i] > max.peek()) {
                second = max.pop();
            }
            max.push(nums[i]);
        }
        return false;
    }
}