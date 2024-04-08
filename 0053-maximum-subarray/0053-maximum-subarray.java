class Solution {
    public int maxSubArray(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }
    
    int solve(int[] nums, int lo, int hi) {
        if(lo >= hi) {
            return nums[lo];
        }
        int mid = lo + (hi - lo) / 2;
        int L = solve(nums, lo, mid - 1);
        int R = solve(nums, mid + 1, hi);// normal binary search
        
        int C = cross(nums, lo, mid, hi);
        return Math.max(L, Math.max(R, C));
    }
    
    int cross(int[] nums, int lo, int mid, int hi) {
        int left = 0, maxLeft = 0;
        int right = 0, maxRight = 0;
        for(int i = mid - 1; i >=lo; i--) {
            left += nums[i];
            maxLeft = Math.max(left, maxLeft);
        }
        for(int i = mid + 1; i <= hi; i++) {
            right += nums[i];
            maxRight = Math.max(right, maxRight);
        }
        return maxLeft + maxRight + nums[mid];
    }
}