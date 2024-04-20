class Solution {
    public int maxSubArray(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }
    
    int solve(int[] nums, int lo, int hi) {
        if(lo >= hi) {
            return nums[lo];
        }
        int mid = lo + (hi-lo)/2;
        
        int left = solve(nums, lo, mid - 1);
        int right = solve(nums, mid + 1, hi);
        int cross = cross(nums, lo, hi, mid);
        return Math.max(left, Math.max(right, cross));
        
    }
    
    int cross(int[] nums, int lo, int hi, int mid) {
        int rightValue = 0;
        int leftValue =0;
        int left = 0;
        int right = 0;
        for(int i=mid - 1; i>=lo; i--) {
            leftValue+=nums[i];
            left = Math.max(left, leftValue);
        }
       // int leftValue = 0;
        for(int i=mid+1; i<=hi; i++) {
            rightValue+=nums[i];
            right = Math.max(right, rightValue);
        }
        
        return nums[mid] + left + right;
    }
}