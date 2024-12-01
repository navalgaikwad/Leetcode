class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int nonCyclic = maxSum(nums);
        int totalSum = 0;
        for(int i=0; i<nums.length; i++) {
            totalSum+=nums[i];
            nums[i]=-nums[i];//vvimp invert karnar by -
        }
        int cyclic = totalSum + maxSum(nums);
         if(cyclic == 0 ) {
            return nonCyclic;
        }
        return Math.max(cyclic, nonCyclic);
    }
    
    int maxSum(int[] nums) {
         int sum =nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(sum < 0) {
                sum = 0;
            }
            sum+=nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}