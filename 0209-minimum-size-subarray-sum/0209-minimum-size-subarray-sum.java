class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = n + 1; // Initialize result to max possible value + 1
        int left = 1; // Minimum possible length
        int right = n; // Maximum possible length

        // Binary search for the minimum length
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isSubArrayExists(nums, mid, target)) {
                result = mid; // Update result with the new minimum length
                right = mid - 1; // Try to find a smaller length
            } else {
                left = mid + 1; // Try to find a valid larger length
            }
        }

        // If result is still n + 1, it means we didn't find any subarray
        return result == n + 1 ? 0 : result;
    }

    private boolean isSubArrayExists(int[] nums, int length, int target) {
        int sum = 0;
        // Calculate the sum of the first 'length' elements
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        // If the sum is already greater than or equal to the target, we found a subarray
        if (sum >= target) {
            return true;
        }
        // Slide the window of 'length' elements and check the sums
        for (int i = length; i < nums.length; i++) {
            sum = sum - nums[i - length] + nums[i]; // Update the sum to reflect the window slide
            if (sum >= target) {
                return true; // We found a subarray
            }
        }
        // No subarray of this length satisfies the condition
        return false;
    }
}
