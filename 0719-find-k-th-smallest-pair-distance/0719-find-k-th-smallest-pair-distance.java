class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length-1] - nums[0];
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            int count = countPairs(nums, mid);
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            } 
        }
        return lo;
    }
    
    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            if (nums[r] - nums[l] <= mid) {
                count += r - l;
                ++r;
            } else {
                ++l;
            }
        }
        return count;
    }
}