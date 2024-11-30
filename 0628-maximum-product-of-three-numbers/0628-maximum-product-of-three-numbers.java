class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        int negative = nums[0] * nums[1] * nums[n];
        int positive = nums[n] * nums[n-1] * nums[n-2];
        return Math.max(negative, positive);
    }
}