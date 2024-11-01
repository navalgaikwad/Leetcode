class Solution {
    public int rob(int[] nums) {
        int len = nums.length - 1;
        Integer[] memo = new Integer[nums.length + 1];
        return helper(nums, nums.length - 1, memo);
    }
    int helper(int[] nums, int i, Integer[] memo) {
        if(i == 0) return nums[0];
        if(i ==1) return Math.max(nums[0], nums[1]);
        if(memo[i] !=null) return memo[i];
        
        int currentToNextToNext = nums[i] + helper(nums, i - 2, memo);
        int next =  helper(nums, i - 1, memo);
        
        int max = Math.max(currentToNextToNext, next);
        memo[i] = max;
        return max;
    }
}