class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        int positive = nums[len-2] * nums[len-1]*nums[len];
        int negative =  nums[0] * nums[1] * nums[len];
        return positive > negative ? positive : negative;
    }
}